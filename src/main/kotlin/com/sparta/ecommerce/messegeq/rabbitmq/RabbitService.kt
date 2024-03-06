package com.sparta.ecommerce.messegeq.rabbitmq

import com.sparta.ecommerce.messegeq.coupon.service.CouponService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class RabbitService(
    private val couponService: CouponService
) {

    @RabbitListener(queues = ["coupon"], containerFactory = "myRabbitListenerContainerFactory")
    fun  receiveMessage(content: String?) {
        val checkedContent = content ?: throw RuntimeException("no content received")
        val (couponId, memberId) = checkedContent.split(" ")
        couponService.afterReceiveMessageHandler(couponId.toLong(), memberId.toLong())
    }
}