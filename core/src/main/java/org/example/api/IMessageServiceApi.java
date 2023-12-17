package org.example.api;

import org.example.model.Message;
import org.springframework.web.bind.annotation.PostMapping;


public interface IMessageServiceApi {

    @PostMapping("/message/mt")
    void mt(Message message);
}
