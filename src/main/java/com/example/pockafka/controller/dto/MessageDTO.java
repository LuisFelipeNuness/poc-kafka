package com.example.pockafka.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageDTO {

    private String id;
    private String message;
}
