package com.sparta.ecommerce.messegeq.coupon.service

import com.sparta.ecommerce.messegeq.coupon.model.CouponBox
import com.sparta.ecommerce.messegeq.coupon.repository.CouponBoxRepository
import com.sparta.ecommerce.messegeq.coupon.repository.CouponRepository
import com.sparta.ecommerce.messegeq.member.MemberRepository
import org.springframework.stereotype.Service

@Service
class CouponService(
    private val couponRepository: CouponRepository,
    private val memberRepository: MemberRepository,
    private val couponBoxRepository: CouponBoxRepository
) {

    fun afterReceiveMessageHandler(couponId: Long, memberId: Long) {
        if (couponRepository.existsById(couponId) && memberRepository.existsById(memberId)) {
            val member = memberRepository.findById(memberId).orElseThrow {
                throw RuntimeException("The Member was not found for provided id")
            }
            val coupon = couponRepository.findById(couponId).orElseThrow{
                throw RuntimeException("The Coupon was not found for provided id")
            }
            if(!couponBoxRepository.existsByMemberAndCoupon(member, coupon)){
                couponBoxRepository.save(CouponBox(member, coupon))
            }else{
                throw RuntimeException("${member.nickname} is already has coupon")
            }
        }

    }
}