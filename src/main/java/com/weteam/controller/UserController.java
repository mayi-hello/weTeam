package com.weteam.controller;

import com.weteam.mapper.*;
import com.weteam.model.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserDao userDao;
    @Autowired
    IAwardDao awardDao;

    /**
     * 个人基本信息
     * @param session
     * @param model
     * @return
     */
    @GetMapping(value = "/personInfo")
    public String personInfo(HttpSession session, Model model){

        // User user = (User)session.getAttribute("user");
        // user = userDao.findUserById(user.getId());

        int id=1;
        User user = userDao.findUserById(id);
        System.out.println(user);
        return null;
    }

    @GetMapping(value = "/userAward")
    public String userAward(HttpSession session){
        // User user = (User)session.getAttribute("user");
        // user = userDao.findUserById(user.getId());

        int id=1;
        List<Award> awards = awardDao.findAwardByUserId(id);
        System.out.println(awards);
        return null;
    }
}
