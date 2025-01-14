package com.example.web_socket.reopository;

import com.example.web_socket.model.entity.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository  extends MongoRepository<ChatMessage, String> {
    List<ChatMessage> findByChatId(String s);
}
