package com.ratelo.payments.core.domain.store

import com.ratelo.payments.core.domain.card.Card
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StoreReader : JpaRepository<Card, Long> {
}
