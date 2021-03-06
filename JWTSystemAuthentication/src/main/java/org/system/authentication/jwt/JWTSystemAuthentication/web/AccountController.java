package org.system.authentication.jwt.JWTSystemAuthentication.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.system.authentication.jwt.JWTSystemAuthentication.entities.AppUser;
import org.system.authentication.jwt.JWTSystemAuthentication.service.IAccountService;

@RestController
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping("tester")
    public String test(){
        return "Hello world 222";
    }

    @PostMapping("register")
    public AppUser registerUser(@RequestBody AppUser user){
       return this.accountService.saveUser(user);
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

}
