package com.example.controller;


import com.example.ajax.AjaxResult;
import com.example.entity.User;
import com.example.service.UserService;

import javafx.scene.control.ChoiceBoxBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    protected AjaxResult toAjax(int rows)
    {
        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
    }



    @GetMapping("/{userId}")
    public AjaxResult getInfo(@PathVariable Long userId)
    {
        return AjaxResult.success(userService.selectUserById(userId));
    }



    @PostMapping
    public AjaxResult add(@Validated @RequestBody User user)
    {
        return toAjax(userService.insertUser(user));
    }




    @PutMapping
    public AjaxResult edit(@Validated @RequestBody User user)
    {
        return toAjax(userService.updateUser(user));
    }



    @DeleteMapping("/{userId}")
    public AjaxResult remove( @PathVariable Long userId)
    {
        return toAjax(userService.deleteUserById(userId));
    }



}
