package com.sparta.ecommerce.messegeq.coupon.repository

import com.sparta.ecommerce.messegeq.coupon.model.Coupon
import com.sparta.ecommerce.messegeq.coupon.model.CouponBox
import com.sparta.ecommerce.messegeq.member.Member
import org.springframework.data.jpa.repository.JpaRepository

interface CouponBoxRepository: JpaRepository<CouponBox, Long> {
    fun existsByMemberAndCoupon(member: Member, coupon: Coupon) : Boolean

}