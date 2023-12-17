package org.example.controller;


import org.example.controller.request.ChannelRequest;
import org.example.controller.response.ChannelResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ChannelController {

    @GetMapping("/channel/queryChannel")
    public ChannelResponse queryChannel() {
        ChannelResponse response = new ChannelResponse();
        response.setStatus(1);
        return response;
    }

    @PostMapping("/channel/addChannel")
    public ChannelResponse addChannel(@Valid @RequestBody ChannelRequest request) {
        System.out.println(request);
        ChannelResponse response = new ChannelResponse();
        response.setStatus(request.getStatus());
        return response;
    }
}
