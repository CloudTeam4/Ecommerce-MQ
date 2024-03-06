package com.sparta.ecommerce.messegeq.coupon.repository

import com.sparta.ecommerce.messegeq.coupon.model.Coupon
import org.springframework.data.jpa.repository.JpaRepository

interface CouponRepository: JpaRepository<Coupon, Long> {
}