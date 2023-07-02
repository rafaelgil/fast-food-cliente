package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.PagamentoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PagamentoRepositorySpring: JpaRepository<PagamentoEntity, UUID> {
}