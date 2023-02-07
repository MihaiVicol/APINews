package com.example.apinews;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


@CrossOrigin(origins= {"*"}, maxAge = 92000, allowCredentials = "false")
@RestController
public class ChatController {
    @GetMapping("/topic")
    public String hello() throws IOException {
       return "Hello!";
    }
    @GetMapping("/top")
    public String helo() throws IOException {
        return "Hello you!";
    }
}
