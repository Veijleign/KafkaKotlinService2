package com.test.kafkaoutboxpatternsecond.kafka.payload

@JvmRecord
data class KafkaUserDTO(
    val userId: Long,
    val email: String,
    val firstName: String,
    val lastName: String,
)
