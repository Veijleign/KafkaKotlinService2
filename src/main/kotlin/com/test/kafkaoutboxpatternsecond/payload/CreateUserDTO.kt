package com.test.kafkaoutboxpatternsecond.payload

@JvmRecord
data class CreateUserDTO(
    val username: String,
    val password: String,
    val firstName: String,
    val lastName: String,
)
