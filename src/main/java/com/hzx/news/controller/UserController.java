package com.hzx.news.controller;

import com.hzx.news.annotation.UserLoginToken;
import com.hzx.news.exception.EmailFormatException;
import com.hzx.news.exception.EmailIsUsedException;
import com.hzx.news.exception.UnickIsUsedException;
import com.hzx.news.pojo.LoginRegisterStatus;
import com.hzx.news.pojo.User;
import com.hzx.news.services.MailService;
import com.hzx.news.services.UserService;
import com.hzx.news.utils.RegisterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userServices;
    @Autowired
    MailService mailService;

//    HashMap<String, User> uncheckUser = new HashMap<>();

    @RequestMapping(value = "register/email", method = RequestMethod.POST)
    @ResponseBody
    public LoginRegisterStatus register(@RequestParam(value = "unick") String unick,
                                        @RequestParam(value = "email") String email,
                                        @RequestParam(value = "password") String password) {
        LoginRegisterStatus status = new LoginRegisterStatus();
        if (!RegisterUtils.checkEmailFormat(email)) {
            status.setCode("400");
            status.setInfo("邮箱格式错误！");
            return status;
        }
        if (userServices.unickIsUsed(unick)) {
            status.setCode("401");
            status.setInfo("该昵称已被占用！");
            return status;
        }
        if (userServices.emailIsUsed(email)) {
            status.setCode("402");
            status.setInfo("该邮箱已被占用！");
            return status;
        }
        User user = new User();
        user.setUnick(unick);
        user.setEmail(email);
        user.setPassword(password);
        int id = userServices.register(user);
        user.setUid(id);
        String token = user.getToken();
        status.setCode("200");
        status.setInfo("注册成功！");
        status.setToken(token);
        return status;
//        String code = UUIDUtils.getUUID();
//        uncheckUser.put(code, user);
//        String subject = "来自News的激活邮件";
        //user/checkCode?code=code(激活码)是我们点击邮件链接之后根据激活码查询用户，如果存在说明一致，将用户状态修改为“1”激活
        //上面的激活码发送到用户注册邮箱
//        String context = "<a href=\"http://localhost:8080/user/checkCode?code=" + code + "\">激活请点击:" + code + "</a>";
        //发送激活邮件
//        mailService.sendHtmlMail(user.getEmail(), subject, context);
    }

    @ResponseBody
    @RequestMapping(value = "login/email", method = RequestMethod.POST)
    public LoginRegisterStatus loginByEmail(@RequestParam(value = "email") String email,
                                            @RequestParam(value = "password") String password,
                                            HttpServletResponse response) {
        LoginRegisterStatus status = new LoginRegisterStatus();
        if (!RegisterUtils.checkEmailFormat(email)) {
            status.setCode("400");
            status.setInfo("邮件格式错误！");
        }
        User user = userServices.loginByEmailAndPassword(email, password);
        if (user != null) {
            Cookie cookie = new Cookie("token", user.getToken());
            response.addCookie(cookie);
            status.setCode("200");
            status.setInfo("登录成功！");
            status.setToken(user.getToken());
            return status;
        } else {
            status.setCode("401");
            status.setInfo("邮箱或密码错误！");
            return status;
        }
    }

    @UserLoginToken
    @ResponseBody
    @RequestMapping("getMessage")
    public String getMessage() {
        return "你已通过验证";
    }

    @ResponseBody
    @RequestMapping(value = "checkCode", method = RequestMethod.GET)
    public String checkCode(String code) {
//        User user = uncheckUser.get(code);
//        if (user == null) {
//            return "failed";
//        }
//        userServices.checkUser(user);
//        uncheckUser.remove(code);
        return "successed";
    }

}
