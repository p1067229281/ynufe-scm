package com.ynufe.scm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author william
 *
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}

