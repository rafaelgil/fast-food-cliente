import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	jacoco
	id("org.springframework.boot") version "3.1.0"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.8.21"
	kotlin("plugin.spring") version "1.8.21"
	kotlin("plugin.jpa") version "1.8.21"
	id("org.flywaydb.flyway") version "9.19.4"
}

group = "br.com.fiap.postech"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.postgresql:postgresql:42.2.1")
	implementation("org.flywaydb:flyway-core:9.19.4")
	implementation("io.jsonwebtoken:jjwt-api:0.11.1")
	implementation("io.jsonwebtoken:jjwt-impl:0.11.1")
	implementation("io.jsonwebtoken:jjwt-jackson:0.11.1")

	implementation("org.springframework.cloud:spring-cloud-aws-messaging:2.1.3.RELEASE")
	implementation("software.amazon.awssdk:sqs:2.16.24")
	implementation("com.amazonaws:aws-java-sdk-core:1.11.589")
	implementation("com.amazonaws:aws-java-sdk:1.11.584")
	implementation("org.springframework.cloud:spring-cloud-aws-messaging:2.1.3.RELEASE")
	implementation("software.amazon.awssdk:sqs:2.16.24")

	testImplementation("org.mockito.kotlin:mockito-kotlin:3.2.0")

	testImplementation("io.cucumber:cucumber-java:6.10.4")
	testImplementation("io.cucumber:cucumber-junit:6.10.4")

	testImplementation("io.rest-assured:spring-mock-mvc:5.3.0")
	testImplementation("io.rest-assured:json-schema-validator:5.3.1")
	testImplementation("io.rest-assured:rest-assured:5.3.0") {
		exclude(group = "org.codehaus.groovy", module = "groovy")
		exclude(group = "org.codehaus.groovy", module = "groovy-xml")
	}

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("junit:junit:4.13.1")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
	finalizedBy(tasks.jacocoTestReport)
}

jacoco {
	toolVersion = "0.8.9"
}

tasks.jacocoTestReport {
	dependsOn(tasks.test)
	reports {
		xml.isEnabled = true
		csv.isEnabled = false
		html.destination = file(layout.buildDirectory.dir("jacoco"))
	}
}

tasks.withType<JacocoCoverageVerification> {
	afterEvaluate {
		classDirectories.setFrom(files(classDirectories.files.map {
			fileTree(it).apply {
				exclude(
						"**/config/**",
						"**/exception/**",
						"**/ControllerAdvice.*",
						"**/FastFoodApplication.*"
				)
			}
		}))
	}
}

tasks.withType<JacocoReport> {
	afterEvaluate {
		classDirectories.setFrom(files(classDirectories.files.map {
			fileTree(it).apply {
				exclude(
						"**/config/**",
						"**/exception/**",
						"**/ControllerAdvice.*",
						"**/FastFoodApplication.*"
				)
			}
		}))
	}
}

val cucumberRuntime by configurations.creating {
	extendsFrom(configurations["testImplementation"])
}

task("cucumber") {
	dependsOn("assemble", "compileTestJava")
	doLast {
		javaexec {
			mainClass.set("io.cucumber.core.cli.Main")
			classpath = cucumberRuntime + sourceSets.main.get().output + sourceSets.test.get().output
			args = listOf(
					"--plugin", "pretty",
					"--plugin", "html:target/cucumber-report.html",
					"--glue", "br.com.fiap.postech.fastfood.cliente.bdd",
					"src/test/resources"
			)
			environment("CUCUMBER_PUBLISH_QUIET", true)
		}
	}
}

flyway {
	url = "jdbc:postgresql://localhost:5432/fast-food-cliente"
	user = "postgres"
	password = "Postgres2023!"
}
