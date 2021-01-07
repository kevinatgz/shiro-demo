package com.example.shirodemo.controller;

import com.example.demodependency.dao.PersonDAL;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public String userLogin(String username, String password) {
        String result;

        //获取当前用户
        Subject currentUser = SecurityUtils.getSubject();

        //用户是否已经登录，未登录则进行登录
        if (!currentUser.isAuthenticated()) {
            //封装用户输入的用户名和密码
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);

            try {
                //登录，进行密码比对，登录失败时将会抛出对应异常
                currentUser.login(usernamePasswordToken);
                result = "登录成功";
            } catch (UnknownAccountException uae) {
                result = "用户名不存在";
            } catch (IncorrectCredentialsException ice) {
                result = "密码错误";
            } catch (LockedAccountException lae) {
                result = "用户状态异常";
            } catch (AuthenticationException ae) {
                result = "登录失败，请与管理员联系";
            }
        } else {
            result = "您已经登录成功了";
        }

        return result;
    }

    @RequestMapping("/list")
    public String userList() {

        LOG.info("Getting all data from MongoDB: \n{}",
                personDAL.getAllPerson());
        return "访问我需要登录并且需要拥有user角色！";
    }

    @Autowired
    private PersonDAL personDAL;

    private static final Logger LOG = LoggerFactory.getLogger("UserController");
}
