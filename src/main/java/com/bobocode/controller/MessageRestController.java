package com.bobocode.controller;

import com.bobocode.dto.Message;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

/**
 * create rest controller with "/messages" endpoint
 */
public class MessageRestController {

    /**
     * save and return Message
     */
    public Message addMessage() {
        return null;
    }


    /**
     * print X-Mood header and save message
     * return saved message
     * @return message
     */
    public Message addMessageAndPrintHeader() {
        return null;
    }

    /**
     * print to console X-Mood header from RequestEntity, get Message from body and save it
     * return ResponseEntity with status created, location of saved message and Message itself
     * @return responseEntity
     */
    public ResponseEntity<Message> addMessageWithResponse() {
        return null;
    }

    /**
     * get message by id
     * @return message
     */
    public Message getOne() {
        return null;
    }

    /**
     * this method get all messages from map as a collection
     * @return messages
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
