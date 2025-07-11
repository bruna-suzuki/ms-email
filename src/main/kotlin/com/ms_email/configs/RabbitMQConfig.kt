package com.ms_email.configs

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.springframework.amqp.core.Queue
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {

    @Value("\${broker.queue.email.name}")
    lateinit var queueName: String

    @Bean
    fun queue(): Queue {
        return Queue(queueName, true)
    }

    @Bean
    fun convertMessage(): Jackson2JsonMessageConverter {
        val objectMapper = jacksonObjectMapper()
        return Jackson2JsonMessageConverter(objectMapper)
    }
}