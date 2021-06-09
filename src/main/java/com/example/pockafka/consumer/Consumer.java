package com.example.pockafka.consumer;

import com.example.pockafka.controller.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(ConsumerRecord<String, MessageDTO> record, Acknowledgment ack){
        log.info("Message received!!" + record.value());
        ack.acknowledge();
    }
}
