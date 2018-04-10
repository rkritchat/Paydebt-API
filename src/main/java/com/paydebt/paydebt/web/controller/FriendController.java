package com.paydebt.paydebt.web.controller;

import com.paydebt.paydebt.service.FriendService;
import com.paydebt.paydebt.web.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/friend")
public class FriendController {

    @Autowired
    private FriendService friendService;

    @PostMapping("/add")
    public ResultJson addFriend(){
        return null;
    }

    @DeleteMapping("/delete")
    public ResultJson deleteFriend(){
        return null;
    }

    @PostMapping("/detail")
    public ResultJson getFriendDetail(){
        return null;
    }

    @PostMapping("/request")
    public ResultJson getFriendRequest(){
        return null;
    }

}
