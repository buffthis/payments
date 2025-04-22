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

@Service
class CardService(
    private val orderValidator : OrderValidator,
    private val storeReader : StoreReader,
    private val cardReader : CardReader,
    private val cardValidator : CardValidator,
    private val cardPaymentProcessor : CardPaymentProcessor,
) {
}