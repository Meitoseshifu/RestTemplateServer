package com.bobocode.controller;

import com.bobocode.dto.Message;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * create rest controller with "/messages" endpoint
 */
public class MessageRestController {

    /**
     * save and return Message
     */
    public Message addMessage(@RequestBody Message message) {
        return addNewMessage(message);
    }


    /**
     * print X-Mood header and save message
     * return saved message
     * @return
     */
    public Message addMessage(RequestEntity<Message> messageRequestEntity) {
        return null;
    }

    /**
     * print to console X-Mood header from RequestEntity, get Message from body and save it
     * return ResponseEntity with status created, location of saved message and Message itself
     * @return
     */
    public ResponseEntity<Message> addMessageWithResponse() {
        return null;
    }

    /**
     * get message by id
     * @return
     */
    public Message getOne() {
        return null;
    }

    /**
     * this method get all messages from map as a collection
     * @return
     */
    public Collection<Message> getAll() {
        return null;
    }

    /**
     * this method set id to message and add it to map
     * @param message
     * @return message
     */
    private Message addNewMessage(Message message) {
        return message;
    }
}
