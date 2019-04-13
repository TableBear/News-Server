package com.hzx.news.controller;

import com.auth0.jwt.JWT;
import com.hzx.news.annotation.UserLoginToken;
import com.hzx.news.mapper.RecordMapper;
import com.hzx.news.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("record")
public class RecordController {
    @Autowired
    RecordMapper recordMapper;

    @UserLoginToken
    @ResponseBody
    @RequestMapping("history")
    public List<News> getHistory(HttpServletRequest request) {
        String token = (String) request.getAttribute("token");
        String uid = JWT.decode(token).getAudience().get(0);
        List<News> news = recordMapper.queryHistory(uid);
        return news;
    }

    @UserLoginToken
    @ResponseBody
    @RequestMapping("collect")
    public List<News> getCollect(HttpServletRequest request) {
        String token = (String) request.getAttribute("token");
        String uid = JWT.decode(token).getAudience().get(0);
        List<News> news = recordMapper.queryCollect(uid);
        return news;
    }

    @UserLoginToken
    @ResponseBody
    @RequestMapping("like")
    public List<News> getLike(HttpServletRequest request) {
        String token = (String) request.getAttribute("token");
        String uid = JWT.decode(token).getAudience().get(0);
        List<News> news = recordMapper.queryLike(uid);
        return news;
    }
}
