package org.example.front.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.C;
import org.example.front.mapper.ChatbotMapper;
import org.example.front.model.*;
import org.example.front.outbound.ChannelApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final ChatbotMapper mapper;
    private final ChannelApi api;

    @PostMapping("/message/mt")
    public void mt(@RequestBody MessageRequest request) {
        System.out.println(request.toString());
    }

    @GetMapping("/channel/addChannel")
    public void add() {
        api.addChannel(new Channel());
    }
}
