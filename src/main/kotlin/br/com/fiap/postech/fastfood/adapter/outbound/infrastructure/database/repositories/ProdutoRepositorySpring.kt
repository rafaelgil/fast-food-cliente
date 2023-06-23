package br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.repositories

import br.com.fiap.postech.fastfood.adapter.outbound.infrastructure.database.entities.ProdutoEntity
import br.com.fiap.postech.fastfood.application.domain.valueObjets.CategoriaProduto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProdutoRepositorySpring : JpaRepository<ProdutoEntity, UUID> {
    fun findByCategoria(categoria: CategoriaProduto): List<ProdutoEntity>?
}