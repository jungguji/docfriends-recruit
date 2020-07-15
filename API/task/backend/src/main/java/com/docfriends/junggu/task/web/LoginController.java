package com.docfriends.junggu.task.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "thymeleaf/login";
    }

    @GetMapping("/login/vue")
    @ResponseBody
    public String loginVue() {
        return "success";
    }
}
