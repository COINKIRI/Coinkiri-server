package com.coinkiri.domain.member

import java.nio.file.Files.readAllBytes
import java.nio.file.Paths
import java.security.MessageDigest
import java.time.LocalDateTime
import java.util.*

data class Member(
    val id: Long? = null,
    val socialId: String,
    val socialType: SocialType,
    val nickname: String,
    val pic: String,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun from(memberCreate: MemberCreate): Member =
            Member(
                socialId = memberCreate.socialId,
                socialType = memberCreate.socialType,
                nickname = generateNickname(memberCreate.socialId, memberCreate.socialType),
                pic = initProfilePic(),
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

        private fun initProfilePic(): String {
            return try {
                val resource = this::class.java.classLoader.getResource("default_image/default_image.png")
                val imagePath = Paths.get(resource.toURI())
                val imageBytes = readAllBytes(imagePath)
                Base64.getEncoder().encodeToString(imageBytes)
            } catch (e: Exception) {
                println("Error reading or encoding image: ${e.message}")
                ""
            }
        }
    }
}
