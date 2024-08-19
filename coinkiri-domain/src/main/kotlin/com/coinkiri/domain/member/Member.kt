package com.coinkiri.domain.member

import java.security.MessageDigest
import java.time.LocalDateTime

data class Member(
    val id: Long? = null,
    val socialId: String,
    val socialType: SocialType,
    val nickname: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun from(memberCreate: MemberCreate): Member =
            Member(
                socialId = memberCreate.socialId,
                socialType = memberCreate.socialType,
                nickname = generateNickname(memberCreate.socialId, memberCreate.socialType),
                createdAt = LocalDateTime.now(),
                updatedAt = LocalDateTime.now()
            )

        private fun generateNickname(socialId: String, socialType: SocialType): String {
            val baseString = "${socialType.value}_$socialId"
            return "user_${baseString.sha256().take(8)}"
        }

        private fun String.sha256(): String {
            val digest = MessageDigest.getInstance("SHA-256").digest(toByteArray())
            return digest.joinToString("") { "%02x".format(it) }
        }
    }
}
