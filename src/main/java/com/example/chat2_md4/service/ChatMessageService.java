package com.example.chat2_md4.service;


import com.example.chat2_md4.model.ChatMessage;
import com.example.chat2_md4.repository.IChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatMessageService implements IChatMessageService {
    @Autowired
    IChatRepository chatRepository;

    @Override
    public Iterable<ChatMessage> findAll() {
        return chatRepository.findAll();
    }

    @Override
    public Optional<ChatMessage> findById(Integer id) {
        return chatRepository.findById(id);
    }

    @Override
    public ChatMessage save(ChatMessage chatMessage) {
        return chatRepository.save(chatMessage);
    }

    @Override
    public void remove(Integer id) {
        chatRepository.deleteById(id);
    }

    @Override
    public Iterable<ChatMessage> findAllBySender(String sender) {
        return chatRepository.findAllBySender(sender);
    }

    @Override
    public Iterable<ChatMessage> findAllBySenderAndAndReceiver(String sender, String receiver) {
        return chatRepository.findAllBySenderAndReceiver(sender,receiver);
    }

    @Override
    public Iterable<ChatMessage> findAllByReceiver(String receiver) {
        return chatRepository.findAllByReceiver(receiver);
    }

    @Override
    public Optional<Integer> findSessionId() {
        return chatRepository.findSessionId();
    }
}
