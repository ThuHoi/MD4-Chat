package com.example.chat2_md4.service;


import com.example.chat2_md4.model.ChatMessage;

import java.util.Optional;

public interface IChatMessageService extends IGeneralService <ChatMessage>{
    Iterable<ChatMessage>findAllBySender(String sender);
    Iterable<ChatMessage>findAllBySenderAndAndReceiver(String sender,String receiver);
    Iterable<ChatMessage>findAllByReceiver(String receiver);
    Optional<Integer> findSessionId();
}
