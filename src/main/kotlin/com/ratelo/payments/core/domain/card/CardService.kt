package com.ratelo.payments.core.domain.card

import com.ratelo.payments.core.domain.order.Order
import com.ratelo.payments.core.domain.order.OrderValidator
import com.ratelo.payments.core.domain.store.Store
import com.ratelo.payments.core.domain.store.StoreReader

import org.springframework.stereotype.Service

@Service
class CardService(
    private val orderValidator: OrderValidator,
    private val storeReader: StoreReader,
    private val cardReader: CardReader,
    private val cardValidator: CardValidator,
    private val cardPaymentProcessor: CardPaymentProcessor,
) {

    fun getCard(id: Long): Card {
        return cardReader.findById(id)
            .orElseThrow { IllegalArgumentException("Card not found with id: $id") }
    }

    fun getCardByNumber(cardNumber: String): Card {
        return cardReader.findByCardNumber(cardNumber)
            ?: throw IllegalArgumentException("Card not found with number: $cardNumber")
    }

    fun getCardsByHolderName(cardHolderName: String): List<Card> {
        return cardReader.findByCardHolderName(cardHolderName)
    }

    fun getAllCards(): List<Card> {
        return cardReader.findAll()
    }
}
