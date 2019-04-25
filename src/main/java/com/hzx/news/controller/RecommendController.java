package com.hzx.news.controller;

import com.auth0.jwt.JWT;
import com.hzx.news.annotation.UserLoginToken;
import com.hzx.news.pojo.News;
import com.hzx.news.pojo.Response;
import com.hzx.news.services.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("recom")
public class RecommendController {
    @Autowired
    RecommendService recommendService;

    @UserLoginToken
    @RequestMapping("news")
    public Response getRecommandNews(@RequestParam(value = "offest") int offest, @RequestParam(value = "limit") int limit, HttpServletRequest request) {
        String token = (String) request.getAttribute("token");
        String uid = JWT.decode(token).getAudience().get(0);
        List<News> list = recommendService.queryRecommendNews(uid, offest,limit);
        Response response = new Response(200, "请求成功", list.size(), true, list);
        return response;
    }
}
