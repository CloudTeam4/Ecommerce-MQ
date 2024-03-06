package com.sparta.ecommerce.messegeq.coupon.model

import com.sparta.ecommerce.messegeq.common.BaseTimeEntity
import jakarta.persistence.*


@Entity
class Coupon(

    @Column(name = "name")
    var name: String,

    @Column(name = "explanation")
    var explanation: String,

    @Column(name = "price")
    var deductedPrice: Int,

    @Column(name = "status")
    var status: String,

    @Column(name = "type")
    var type: String, // 할인방식

    @Column(name = "statufields")
    var field: String, // 사용 가능 형식

) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val couponId: Long? = null
}