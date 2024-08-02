package com.test.kafkaoutboxpatternsecond.kafka.config

import org.springframework.context.annotation.Configuration

@Configuration
class TopicConfiguration {

    companion object {
        const val FIRST_TO_SECOND: String = "FIRST_TO_SECOND"
        const val SECOND_TO_FIRST = "SECOND_TO_FIRST"
    }

}