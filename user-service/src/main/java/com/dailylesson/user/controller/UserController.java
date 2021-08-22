package com.dailylesson.user.controller;

import com.dailylesson.user.VO.ResponseTemplateVO;
import com.dailylesson.user.entity.User;
import com.dailylesson.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userid){
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userid);
    }
}
