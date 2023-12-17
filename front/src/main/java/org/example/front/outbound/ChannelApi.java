package org.example.front.outbound;

import org.example.front.model.Channel;
import org.springframework.web.bind.annotation.PostMapping;

public interface ChannelApi {

    @PostMapping("/channel/addChannel")
    void addChannel(Channel channel);
}
