package com.example.pockafka.producer;

import com.example.pockafka.controller.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Producer {

    private final String topic;
    private final KafkaTemplate<String, MessageDTO> template;

    public Producer(@Value("${topic.name}") String topic,
                    KafkaTemplate<String, MessageDTO> template) {
        this.topic = topic;
        this.template = template;
    }

    public void send(MessageDTO messageDTO) {
        template.send(topic, messageDTO).addCallback(
                success -> log.info("Message send!! " + success.getProducerRecord().value()),
                failure -> log.info("Message failure!!" + failure.getMessage())
        );
    }
}
