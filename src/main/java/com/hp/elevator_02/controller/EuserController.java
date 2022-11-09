package com.hp.elevator_02.controller;

import com.hp.elevator_02.pojo.Euser;
import com.hp.elevator_02.service.EuserService;
import com.hp.elevator_02.utils.VerifyCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录
 */
@Controller
@RequestMapping("/euser")
public class EuserController {

    @Autowired
    private EuserService euserService;

    //显示登录页面
    @GetMapping("/showLogin")
    public String showLogin(){
        return "/view/eUser/login.html";
    }
    //显示首页页面
    @GetMapping("/index")
    public String index(){
        return "/view/eUser/index.html";
    }
    //登录
    @PostMapping("/login")
    @ResponseBody
    public String login(Euser euser, HttpSession session,String verifyCode){
        Euser login = euserService.login(euser);
        //从session取生成的验证码
        String verCode = (String) session.getAttribute("verCode");
        if(verCode.equals(verifyCode.toLowerCase())){
            if(login!=null){
                //登录成功
                session.setAttribute("login",login);
                return "index";
            }else {
                //登录不成功
                return "showLogin";
            }
        }else {
            return "error";
        }
    }
    //验证码失败
    @PostMapping("/error")
    @ResponseBody
    public String error(){
        return "/view/eUser/login.html";
    }
    @RequestMapping("/generateCheckCode")
    public void generateCheckCode(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        // 存入会话session
        HttpSession session = request.getSession(true);
        // 删除以前的
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase());
        // 生成图片
        int w = 125, h = 38;
        try {
            VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
