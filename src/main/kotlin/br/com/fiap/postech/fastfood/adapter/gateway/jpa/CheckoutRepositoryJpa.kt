package br.com.fiap.postech.fastfood.adapter.gateway.jpa

import br.com.fiap.postech.fastfood.adapter.gateway.schema.CheckoutSchema
import br.com.fiap.postech.fastfood.domain.entity.Pagamento
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CheckoutRepositoryJpa : JpaRepository<CheckoutSchema, UUID> {

}