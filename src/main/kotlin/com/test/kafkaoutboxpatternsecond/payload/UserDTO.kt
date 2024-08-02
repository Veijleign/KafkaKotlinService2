package com.test.kafkaoutboxpatternsecond.payload

@JvmRecord
data class UserDTO(
    val id: Long?,
    val username: String,
    val firstName: String,
    val lastName: String,
)
