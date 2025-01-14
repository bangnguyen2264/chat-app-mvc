package com.example.web_socket.service;

import com.example.web_socket.model.entity.ChatMessage;
import com.example.web_socket.reopository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage){
        var chatId = chatRoomService.getChatRoomId(
                chatMessage.getSenderId(),
                chatMessage.getRecipientId(),
                true
                        ).orElseThrow();
        chatMessage.setChatId(chatId);
        chatMessageRepository.save(chatMessage);
        return chatMessage;
    }

    public List<ChatMessage> findChatMessage(
            String senderId, String recipientid
    ){
        var chatId = chatRoomService.getChatRoomId(
                senderId,
                recipientid,
                false
        );

        return chatId.map(chatMessageRepository::findByChatId).orElse(new ArrayList<>());

    }
}
