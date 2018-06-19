package org.system.authentication.jwt.JWTSystemAuthentication.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("tester")
    public String test(){
        return "Hello world";
    }

}
