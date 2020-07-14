package com.docfriends.junggu.task.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/login/test")
    @ResponseBody
    public String login() {
        return "success";
    }
}
