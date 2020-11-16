package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {

    public User selectUserById(Long userId);

    public int insertUser(User user);

    public int deleteUserById(Long userId);

    public int updateUser(User user);
}
