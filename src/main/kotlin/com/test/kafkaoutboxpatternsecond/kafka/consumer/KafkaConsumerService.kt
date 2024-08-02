package com.test.kafkaoutboxpatternsecond.kafka.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import com.test.kafkaoutboxpatternsecond.kafka.config.TopicConfiguration
import com.test.kafkaoutboxpatternsecond.payload.UserDTO
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

@Service
@Slf4j
class KafkaConsumerService(
    private val objectMapper: ObjectMapper
) {
    lateinit var logger: Logger

    @KafkaListener(
        topics = [TopicConfiguration.FIRST_TO_SECOND],
        groupId = "try1",
        containerFactory = "kafkaListenerContainerFactory",
    )
    fun consume(@Payload message : ByteArray) {
        val userDto : UserDTO = objectMapper.readValue(message, UserDTO::class.java)

        logger.info("Received message $userDto")

    }

}