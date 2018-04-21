package com.paydebt.paydebt.web.controller;

import com.paydebt.paydebt.form.UserForm;
import com.paydebt.paydebt.service.UserService;
import com.paydebt.paydebt.web.ResultJson;
import com.pusher.rest.Pusher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResultJson login(@RequestBody UserForm userForm){
        Pusher pusher = new Pusher("506887", "683ba8fecc034bbc27e3", "9bd90db13d621d64c3cc");
        pusher.setCluster("ap1");
        pusher.setEncrypted(true);

        pusher.trigger("my-channel",
                "my-event", Collections.singletonMap("message", "hello world"+userForm.getId()));
        return userService.login(userForm);
    }

    @PutMapping
    public ResultJson register(@RequestBody UserForm userForm){
        return userService.register(userForm);
    }

    @PatchMapping("/pwd")
    public ResultJson updatePassword(@RequestBody UserForm userForm){
        return userService.updatePassword(userForm);
    }

    @PatchMapping("/detail")
    public ResultJson updateUserDetail(@RequestBody UserForm userForm){
        return userService.updateUserDetail(userForm);
    }

}