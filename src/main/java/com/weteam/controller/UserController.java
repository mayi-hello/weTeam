package com.weteam.controller;

import com.weteam.entity.User;
import com.weteam.repository.UserRepository;
import com.weteam.utils.BasicResponse;
import com.weteam.utils.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UserController {

    @Resource
    UserRepository userRepository;

    @Resource
    SessionHelper sessionHelper;

    @GetMapping("/user/login")
    private String getLogin(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if (session == null) {
            return "user/login";
        }
        User user = userRepository.findById((Integer) session.getAttribute("userId")).orElse(null);
        if (user == null) {
            session.invalidate();
            return "redirect:/user/login";
        }
        return "redirect:/user/index";
    }

    @ResponseBody
    @PostMapping("/user/login")
    private ResponseEntity<BasicResponse> login(@RequestParam("username") String username,
                                                @RequestParam("password") String password,
                                                HttpSession session){
        try {
            sessionHelper.login(session, username, password);
            return ResponseEntity.ok().body(BasicResponse.ok().message("登录成功"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(BasicResponse.fail().message(e.getMessage()));
        }

    }

    @RequestMapping("/")
    public void login(HttpServletResponse response) throws IOException {
        //这里是回调的url
        String APPID = "wx40c243ab429ab596";
        String scope = "snsapi_userinfo";
        String redirect_uri = URLEncoder.encode("127.0.0.1:8080/user/index", "UTF-8");
        String url = "https://open.weixin.qq.com/connect/oauth2/authorize?" +
                "appid=" + APPID + "&redirect_uri=" + redirect_uri + "&response_type=code" +
                "&scope=" + scope + "&state=123#wechat_redirect";
        response.sendRedirect(url);
    }

}
