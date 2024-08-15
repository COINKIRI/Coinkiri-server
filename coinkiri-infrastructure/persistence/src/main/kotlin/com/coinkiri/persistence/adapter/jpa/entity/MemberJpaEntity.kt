package com.coinkiri.persistence.adapter.jpa.entity

import com.coinkiri.domain.member.Member
import com.coinkiri.domain.member.SocialType
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "members")
data class MemberJpaEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val socialId: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val socialType: SocialType,

    @Column(nullable = false)
    val nickname: String,

    @Column(nullable = false)
    val createdAt: LocalDateTime,

    @Column(nullable = false)
    val updatedAt: LocalDateTime

) {
    companion object {
        fun from(member: Member): MemberJpaEntity {
            return MemberJpaEntity(
                id = member.id,
                socialId = member.socialId,
                socialType = member.socialType,
                nickname = member.nickname,
                createdAt = member.createdAt,
                updatedAt = member.updatedAt
            )
        }
    }

    fun toDomain(): Member {
        return Member(
            id = id,
            socialId = socialId,
            socialType = socialType,
            nickname = nickname,
            createdAt = createdAt,
            updatedAt = updatedAt
        )
    }
}
