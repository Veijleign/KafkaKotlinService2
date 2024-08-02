package com.test.kafkaoutboxpatternsecond.kafka.consumer

import com.fasterxml.jackson.databind.ObjectMapper
import com.test.kafkaoutboxpatternsecond.kafka.config.TopicConfiguration
import com.test.kafkaoutboxpatternsecond.kafka.payload.KafkaUserDTO
import io.github.oshai.kotlinlogging.KotlinLogging
import lombok.extern.slf4j.Slf4j
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

@Service
@Slf4j
class KafkaConsumerService(
    private val objectMapper: ObjectMapper
) {
    private val logger = KotlinLogging.logger {}

    @KafkaListener(
        topics = [TopicConfiguration.FIRST_TO_SECOND],
        groupId = "try1",
        containerFactory = "kafkaListenerContainerFactory",
    )
    fun consume(@Payload message : ByteArray) {
        val userDto : KafkaUserDTO = objectMapper.readValue(message, KafkaUserDTO::class.java)

        logger.info { "Get user paginated: filter $userDto" }

    }

}