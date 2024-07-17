package com.ijse.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdouctController {
    @GetMapping("/product")
    public String sayproduct(){
        return "product is created";
    }

     @PostMapping("/product")
    public String PostRequest(){
        return("This is a POST request to Hello End point");
    }

}
