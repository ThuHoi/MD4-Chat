package com.example.chat2_md4.controller;


import com.example.chat2_md4.model.ChatMessage;
import com.example.chat2_md4.repository.IChatRepository;
import com.example.chat2_md4.service.IChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin("*")
public class ChatRestController {
    @Autowired
    HttpSession httpSession;

    @Autowired
    private IChatMessageService iChatMessageService;

    @GetMapping("/response")
    public ResponseEntity<Iterable<ChatMessage>> getI(@RequestParam String sender) {
        return new ResponseEntity<>(iChatMessageService.findAllBySender(sender), HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Optional<Integer>> getSessionId() {
        return new ResponseEntity<>(iChatMessageService.findSessionId(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<ChatMessage>> index(String sender, String receiver) {
        return new ResponseEntity<>(iChatMessageService.findAllBySenderAndAndReceiver(sender,receiver), HttpStatus.OK);
    }

}
