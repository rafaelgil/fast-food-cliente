package br.com.fiap.postech.fastfood.cliente.adapter.gateway.jpa

import br.com.fiap.postech.fastfood.cliente.adapter.gateway.schema.ClienteSchema
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.data.jpa.repository.Modifying
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Repository
interface ClienteRepositoryJpa : JpaRepository<ClienteSchema, UUID> {
    @Query("SELECT c FROM cliente c WHERE c.cpf = :cpf AND c.excluidoEm IS NULL")
    fun findByCpf(@Param("cpf") cpf: String): ClienteSchema

    @Query("select case when count(c) > 0 then true else false " +
            "end from cliente c where " +
            "(lower(c.cpf) like lower(:cpf) or " +
            "lower(c.email) like lower(:email)) " +
            "AND c.excluidoEm IS NULL")
    fun existsCpfOrEmail(@Param("cpf") cpf: String, @Param("email") email: String): Boolean

    @Modifying
    @Transactional
    @Query("update cliente c set c.excluidoEm = CURRENT_TIMESTAMP where c.cpf = :cpf")
    fun excluirLogicamentePorCpf(@Param("cpf") cpf: String): Int

    @Query("SELECT c FROM cliente c WHERE c.nome = :nome AND c.cpf = :cpf AND c.email = :email AND c.endereco = :endereco AND c.excluidoEm IS NULL")
    fun buscarClientePorNomeCpfEmail(@Param("nome") nome: String, @Param("cpf") cpf: String, @Param("email") email: String, @Param("endereco") endereco: String): ClienteSchema
}