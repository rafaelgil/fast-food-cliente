package br.com.fiap.postech.fastfood.adapter.gateway.jpa

import br.com.fiap.postech.fastfood.adapter.gateway.schema.ClienteSchema
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ClienteRepositoryJpa : JpaRepository<ClienteSchema, UUID> {
    fun findByCpf(cpf: String): ClienteSchema

    @Query("select case when count(c) > 0 then true else false " +
            "end from cliente c where " +
            "lower(c.cpf) like lower(:cpf) or " +
            "lower(c.email) like lower(:email)")
    fun existsCpfOrEmail(@Param("cpf") cpf: String, @Param("email") email: String): Boolean
}