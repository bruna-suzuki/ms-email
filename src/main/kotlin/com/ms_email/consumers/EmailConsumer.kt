package com.ms_email.consumers

import com.ms_email.dtos.EmailDto
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class EmailConsumer {

    @RabbitListener(queues = arrayOf("\${broker.queue.email.name}"))
    fun listenEmailQueue(@Payload emailDto: EmailDto) {
        println("${emailDto.userName}, bora no Candlelight: O Melhor de Hans Zimmer dia 26 de julho?")
    }
}