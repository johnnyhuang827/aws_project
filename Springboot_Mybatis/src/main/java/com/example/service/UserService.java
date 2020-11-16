package com.example.service;


import com.example.entity.User;

public interface UserService {


    public User selectUserById(Long userId);


    public int insertUser(User user);


    public int deleteUserById(Long userId);


    public int updateUser(User user);


}
