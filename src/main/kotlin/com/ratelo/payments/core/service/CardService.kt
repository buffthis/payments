package com.ratelo.payments.core.service

import com.ratelo.payments.core.component.CardPaymentProcessor
import com.ratelo.payments.core.component.CardValidator
import com.ratelo.payments.core.component.OrderValidator
import com.ratelo.payments.core.dataaccess.CardReader
import com.ratelo.payments.core.dataaccess.StoreReader
import com.ratelo.payments.core.vo.Card
import com.ratelo.payments.core.vo.CardPaymentRequest
import com.ratelo.payments.core.vo.CustomerCard
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
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
