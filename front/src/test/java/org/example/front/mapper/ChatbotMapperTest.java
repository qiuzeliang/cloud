package org.example.front.mapper;

import org.example.front.model.ChatbotQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ChatbotMapperTest {

    @Autowired
    private ChatbotMapper mapper;

    @Test
    public void findByStateTest() {
//        Assertions.assertNotNull(mapper.selectChatbot(new ChatbotQuery().setChatbotNo("95566")));
//        Assertions.assertNotNull(mapper.selectChatbot(new ChatbotQuery().setChatbotNo("95566")));
//        Assertions.assertNotNull(mapper.selectChatbot(new ChatbotQuery().setChatbotNo("95566")));
        System.out.println(mapper.selectChatbot(new ChatbotQuery().setChatbotNo("95566")));
        System.out.println(mapper.selectChatbot(new ChatbotQuery().setChatbotNo("95566")));
    }

}