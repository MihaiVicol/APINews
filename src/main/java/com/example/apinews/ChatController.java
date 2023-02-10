package com.example.apinews;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.io.*;
import java.util.List;


@RestController
public class ChatController {
    @PostMapping("/topic")
    public List<Article> hello(@RequestBody DataFE dataFe) throws IOException {
        if(dataFe.getKeyword() != null) {
            String uri = "https://newsapi.org/v2/everything?q=" + Character.toString((char) 34);
            uri += dataFe.getKeyword() + Character.toString((char) 34);
            uri += "&from=" + dataFe.getDateST() +"&to=" + dataFe.getDateND();
            uri += "&sortBy=popularity&apiKey=f64197ac47514e499cdd1b9a0e911cde";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();
            NewsData newsData = mapper.readValue(restTemplate.getForObject(uri, String.class), NewsData.class);
            return newsData.getArticles();
        }
        else{
            String uri = "https://newsapi.org/v2/top-headlines?country=";
            uri+= dataFe.getCountry();
            uri+= "&category=" + dataFe.getCategory();
            uri += "&apiKey=f64197ac47514e499cdd1b9a0e911cde";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();
            NewsData newsData = mapper.readValue(restTemplate.getForObject(uri, String.class), NewsData.class);
            return newsData.getArticles();
        }
    }
    @GetMapping("/top")
    public String helo() throws IOException {
        return "Hello you!";
    }
}
