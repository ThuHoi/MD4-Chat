package com.example.chat2_md4.repository;


import com.example.chat2_md4.model.ChatMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IChatRepository extends CrudRepository<ChatMessage,Integer> {
    Iterable<ChatMessage>findAllBySender(String sender);

    @Query(value = "select * from chat u where (u.sender = ?1 and u.receiver = ?2) or (u.sender = ?2 and u.receiver = ?1) ", nativeQuery = true)
    Iterable<ChatMessage>findAllBySenderAndReceiver(String sender,String receiver);

    Iterable<ChatMessage>findAllByReceiver(String receiver);


    @Query(value = "select * from chat u where (u.user_id = ?1 and u.receiver = ?2) or (u.user_id = ?2 and u.receiver = ?1) ", nativeQuery = true)
    Iterable<ChatMessage>findAllByUserIDAndReceiver(String user_id,String receiver);

    @Query(value = "SELECT id_user FROM session ORDER BY ID DESC LIMIT 1;", nativeQuery = true)
    Optional<Integer> findSessionId();

}
