package com.test.kafkaoutboxpatternsecond.payload

@JvmRecord
data class UserDTO(
    val id: Long?,
    val email: String,
    val firstName: String,
    val lastName: String,
)
