package com.example.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 14:39
 */
public class User {

    @NotNull(message = "id不能为空")
    private Long userId;

    @Size(min = 0, max = 30, message = "用户名长度不能超过30个字符")
    private String userName;

    private Integer userDepartment; //部门id

    private String userDepartmentName; //部门名

    private Integer userState; //状态

    private Date userCreateTime; //创建时间


    public Long getuserId() {
        return userId;
    }

    public void setuserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(Integer userDepartment) {
        this.userDepartment = userDepartment;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public String getUserDepartmentName() {
        return userDepartmentName;
    }

    public void setUserDepartmentName(String userDepartmentName) {
        this.userDepartmentName = userDepartmentName;
    }

}
