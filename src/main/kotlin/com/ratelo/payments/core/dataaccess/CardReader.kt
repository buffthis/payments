package com.ratelo.payments.core.dataaccess

import com.ratelo.payments.core.vo.Card
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CardReader : JpaRepository<Card, Long> {
    fun findByCardNumber(cardNumber: String): Card?
    fun findByCardHolderName(cardHolderName: String): List<Card>
}
