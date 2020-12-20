package com.huangyong.controller;

import com.google.code.kaptcha.Producer;
import com.huangyong.pojo.User;
import com.huangyong.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    private Producer kaptchaProducer;

    @RequestMapping("/login")
    public Map<String,Object> login(String username, String password, String yanzhengma, HttpSession session){
        Map<String,Object> map =new HashMap<>();
        String text = (String) session.getAttribute("kaptcha");

        if(text.equals(yanzhengma.toUpperCase())) {
            System.out.println(DigestUtils.md5DigestAsHex(password.getBytes()));
            User user = loginService.login(username, DigestUtils.md5DigestAsHex(password.getBytes()));
            if (user != null) {
                map.put("error", "成功");
                session.setAttribute("user",user);
                session.setMaxInactiveInterval(604800);
            } else {
                map.put("error", "失败");
            }
        }else{
            map.put("msg","验证码错误");
        }
        return map;
    }

    @RequestMapping(path = "/kaptcha", method = RequestMethod.GET)
    public void getKaptcha(HttpServletResponse response, HttpSession session) {
        // 生成验证码
        String text = kaptchaProducer.createText();
        BufferedImage image = kaptchaProducer.createImage(text);

        // 将验证码存入session
        session.setAttribute("kaptcha", text);

        // 将突图片输出给浏览器
        response.setContentType("image/png");
        try {
            OutputStream os = response.getOutputStream();
            ImageIO.write(image, "png", os);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
