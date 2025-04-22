package com.ratelo.payments.core.dataaccess

import com.ratelo.payments.core.vo.Card
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StoreReader : JpaRepository<Card, Long> {
}
