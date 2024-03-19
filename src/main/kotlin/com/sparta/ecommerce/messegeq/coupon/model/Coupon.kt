package com.sparta.ecommerce.messegeq.coupon.model

import com.sparta.ecommerce.messegeq.common.BaseTimeEntity
import com.sparta.ecommerce.messegeq.member.Member
import jakarta.persistence.*


@Entity
class Coupon(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    val member: Member,

    @Column(name = "name")
    var name: String,

    @Column(name = "explanation")
    var explanation: String,

    @Column(name = "price")
    var deductedPrice: Int,

    @Column(name = "status")
    var status: String,

    @Column(name = "type")
    var type: Boolean, // 중복 사용 가능 여부

    @Column(name = "statufields")
    var applicable: String, // 적용 가능 대상

    @Column(name = "quantity")
    var quantity: Int

) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val couponId: Long? = null
}