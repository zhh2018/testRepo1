package com.jk.controller;

import com.jk.model.User;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService  userService;

    @RequestMapping("queryUserdata")
    @ResponseBody
    public  Map<String,Object>  queryUserdata(Integer pageSize, Integer start, User user){
        Map<String,Object> man=  userService.queryUserdata(pageSize,start,user);
    return  man;
    }

}
