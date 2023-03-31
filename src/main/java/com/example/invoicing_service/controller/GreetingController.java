package com.example.invoicing_service.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class GreetingController {

    @GetMapping
    //add method to return greetings
    public String greeting()
    {
        return "Greeting!";
    }
}