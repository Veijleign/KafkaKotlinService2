package com.test.kafkaoutboxpatternsecond.domain.entity

import jakarta.persistence.*


@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var userId: Long? = null,

    @Column(nullable = false)
    var email: String,

    @Column(nullable = false)
    var firstName: String,

    @Column(nullable = false)
    var lastName: String
) {

    var password: String? = null

    fun toDto() = User(
        userId = this.userId,
        email = this.email,
        firstName = this.firstName,
        lastName = this.lastName
    )
}