package com.sparta.ecommerce.messegeq.coupon.service

import com.sparta.ecommerce.messegeq.coupon.model.CouponBox
import com.sparta.ecommerce.messegeq.coupon.repository.CouponBoxRepository
import com.sparta.ecommerce.messegeq.coupon.repository.CouponRepository
import com.sparta.ecommerce.messegeq.member.MemberRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CouponService(
    private val couponRepository: CouponRepository,
    private val memberRepository: MemberRepository,
    private val couponBoxRepository: CouponBoxRepository
) {
    private val logger = LoggerFactory.getLogger(CouponService::class.java)

    @Transactional
    fun afterReceiveMessageHandler(couponId: Long, memberId: Long) {
        val member = memberRepository.findById(memberId).orElseThrow {
            throw RuntimeException("The Member was not found for provided id")
        }
        val coupon = couponRepository.findById(couponId).orElseThrow {
            throw RuntimeException("The Coupon was not found for provided id")
        }

        couponBoxRepository.save(CouponBox(member, coupon))
        logger.info("Saved")

    }
}