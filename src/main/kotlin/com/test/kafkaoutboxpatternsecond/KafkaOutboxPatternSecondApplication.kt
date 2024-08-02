package com.test.kafkaoutboxpatternsecond

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaOutboxPatternSecondApplication

fun main(args: Array<String>) {
    runApplication<KafkaOutboxPatternSecondApplication>(*args)
}
