package com.example.pockafka.controller;

import com.example.pockafka.controller.dto.MessageDTO;
import com.example.pockafka.producer.Producer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
@Slf4j
public class Controller {

    private final Producer producer;

    @PostMapping
    public void sendMessage(@RequestBody MessageDTO messageDTO){

        try {
            producer.send(MessageDTO.builder()
                    .id(UUID.randomUUID().toString())
                    .message(messageDTO.getMessage())
                    .build());
        }catch (Exception e) {
            log.info(e.getMessage());
        }

    }
}
