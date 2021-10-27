package com.bobocode.controller;

import com.bobocode.dto.Message;
import com.bobocode.exception.MessageNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/messages")
public class MessageRestController {
    private AtomicLong idGenerator = new AtomicLong();
    private Map<Long, Message> messageMap = new ConcurrentHashMap<>();

    @PostMapping("/message")
    public Message addMessage(@RequestBody Message message) {
        return addNewMessage(message);
    }

    @PostMapping("/requestentity")
    public Message addMessage(RequestEntity<Message> messageRequestEntity) {
        Optional.ofNullable(messageRequestEntity
                        .getHeaders()
                        .get("X-Mood"))
                .ifPresent(System.out::println);
        return addNewMessage(Objects.requireNonNull(messageRequestEntity.getBody()));
    }

    @PostMapping("/responseentity")
    public ResponseEntity<Message> addMessageWithResponse(RequestEntity<Message> messageRequestEntity) {
        Optional.ofNullable(messageRequestEntity
                        .getHeaders()
                        .get("X-Mood"))
                .ifPresent(System.out::println);
        Message message = addNewMessage(Objects.requireNonNull(messageRequestEntity.getBody()));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .location(URI.create("http://93.175.204.87:8080/messages" + message.getId()))
                .body(message);
    }

    @GetMapping("/{id}")
    public Message getOne(@PathVariable Long id) {
        return Optional.ofNullable(messageMap.get(id))
                .orElseThrow(() -> new MessageNotFoundException("Cannot find message by id = " + id));
    }

    @GetMapping
    public Collection<Message> getAll() {
        return messageMap.values();
    }

    private Message addNewMessage(Message message) {
        message.setId(idGenerator.incrementAndGet());
        messageMap.put(message.getId(), message);
        return message;
    }
}
