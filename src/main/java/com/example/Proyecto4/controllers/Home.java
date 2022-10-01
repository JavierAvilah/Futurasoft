package com.example.Proyecto4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {

    @GetMapping("inicio")
    public String inicio(){
        return "master";
    }
}
