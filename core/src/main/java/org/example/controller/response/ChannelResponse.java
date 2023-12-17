package org.example.controller.response;

import lombok.Data;
import org.example.valid.ChannelStatus;

@Data
public class ChannelResponse {

    @ChannelStatus
    private int status;
}
