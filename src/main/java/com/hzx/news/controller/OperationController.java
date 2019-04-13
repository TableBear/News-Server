package com.hzx.news.controller;

import com.auth0.jwt.JWT;
import com.hzx.news.annotation.UserLoginToken;
import com.hzx.news.services.NewsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Controller
@RequestMapping("opt")
public class OperationController {
    @Autowired
    NewsLogService newsLogService;

    @ResponseBody
    @UserLoginToken
    @RequestMapping(value = "collect", method = RequestMethod.POST)
    public String collect(@RequestParam(value = "nid") String nid,
                          HttpServletRequest request) {
        String token = (String) request.getAttribute("token");
        String uid = JWT.decode(token).getAudience().get(0);
        Date date = new Date();
        newsLogService.collect(uid, nid, date);
        return "success";
    }

    @ResponseBody
    @UserLoginToken
    @RequestMapping(value = "cancleCollect", method = RequestMethod.POST)
    public String cancleCollect(@RequestParam(value = "nid") String nid,
                                HttpServletRequest request) {
        String token = (String) request.getAttribute("token");
        String uid = JWT.decode(token).getAudience().get(0);
        newsLogService.cancleCollect(uid, nid, new Date());
        return "success";
    }

    @ResponseBody
    @UserLoginToken
    @RequestMapping(value = "like", method = RequestMethod.POST)
    public String like(@RequestParam(value = "nid") String nid,
                       HttpServletRequest request) {
        String token = (String) request.getAttribute("token");
        String uid = JWT.decode(token).getAudience().get(0);
        newsLogService.like(uid, nid, new Date());
        return "success";
    }

    @ResponseBody
    @UserLoginToken
    @RequestMapping(value = "cancleLike", method = RequestMethod.POST)
    public String cancleLike(@RequestParam(value = "nid") String nid,
                             HttpServletRequest request) {
        String token = (String) request.getAttribute("token");
        String uid = JWT.decode(token).getAudience().get(0);
        newsLogService.cancleLike(uid, nid, new Date());
        return "success";
    }

    @ResponseBody
    @UserLoginToken
    @RequestMapping(value = "click", method = RequestMethod.POST)
    public String click(@RequestParam(value = "nid") String nid,
                        HttpServletRequest request) {
        String token = (String) request.getAttribute("token");
        String uid = JWT.decode(token).getAudience().get(0);
        newsLogService.click(uid, nid, new Date());
        return "success";
    }
}
