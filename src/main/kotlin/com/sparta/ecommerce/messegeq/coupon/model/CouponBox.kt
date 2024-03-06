package com.sparta.ecommerce.messegeq.coupon.model

import com.sparta.ecommerce.messegeq.member.Member
import jakarta.persistence.*

@Entity
class CouponBox(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    val member: Member,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id", nullable = false)
    val coupon: Coupon

) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val couponBoxId: Long? = null

}