package org.example.front.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.example.front.factory.AppFactory;
import org.example.front.model.Chatbot;
import org.example.front.model.ChatbotQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
@Transactional
@CacheNamespace( implementation = CaffeineCache.class)
public interface ChatbotMapper {

    @Insert("insert ignore into t_chatbot(chatbot_no, chatbot_status, channel_status, create_time) values(#{chatbotNo}, #{chatbotStatus}, #{channelStatus}, #{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    boolean insertChatbot(Chatbot chatbot);

    default boolean insertChatbots(List<Chatbot> chatbots) {
        try (SqlSession session = AppFactory.getBean(SqlSessionFactory.class).openSession(ExecutorType.BATCH, true)) {
            ChatbotMapper mapper = session.getMapper(ChatbotMapper.class);
            chatbots.forEach(mapper::insertChatbot);
            List<BatchResult> results = session.flushStatements();
            return results.stream().map(BatchResult::getUpdateCounts).findAny().isPresent();
        }
    }

    @Select("select * from t_chatbot where chatbot_no=#{chatbotNo}")
    Chatbot selectChatbot(ChatbotQuery query);

    @Update("update t_chatbot set chatbot_status=#{chatbotStatus} where chatbot_no=#{chatbotNo}")
    boolean updateChatbot(Chatbot chatbot );
    @SelectProvider
    @DynamicSql("select * from t_chatbot where chatbot_no=#{chatbotNo} and chatbot_status=#{chatbotStatus}")
    Chatbot dynamic(ChatbotQuery query);
}
