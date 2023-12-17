package org.example.front.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class Chatbot {

    private String id;

    private String chatbotNo;

    private ChatbotStatus chatbotStatus;

    private ChannelStatus channelStatus;

    private Timestamp createTime;
}
