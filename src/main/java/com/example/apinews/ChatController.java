package com.example.apinews;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.io.*;
import java.util.List;
import java.util.StringTokenizer;


@RestController
public class ChatController {
    @GetMapping("/top/{country}/{category}")
    public List<Article> hello(@PathVariable String country, @PathVariable String category) throws IOException {
            String uri = "https://newsapi.org/v2/top-headlines?country=";
            uri+= country;
            uri+= "&category=" + category;
            uri += "&apiKey=f64197ac47514e499cdd1b9a0e911cde";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();
            NewsData newsData = mapper.readValue(restTemplate.getForObject(uri, String.class), NewsData.class);
            return newsData.getArticles();
    }
    @GetMapping("/top/{id}/{stDate}/{ndDate}")
    public List<Article> helo(@PathVariable String id, @PathVariable String stDate, @PathVariable String ndDate) throws IOException {
        StringTokenizer tokens = new StringTokenizer(id, "-");
        System.out.println(id+stDate+ndDate);
        String uri = "https://newsapi.org/v2/everything?q=" + Character.toString((char) 34);
        for (int i = 1; tokens.hasMoreTokens(); i++)
            uri += tokens.nextToken() + " ";
        System.out.println("sadas");
        uri += Character.toString((char) 34);
        uri += "&from=" + stDate +"&to=" + ndDate;
        uri += "&sortBy=popularity&apiKey=f64197ac47514e499cdd1b9a0e911cde";
        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();
        NewsData newsData = mapper.readValue(restTemplate.getForObject(uri, String.class), NewsData.class);
        return newsData.getArticles();
    }
}
