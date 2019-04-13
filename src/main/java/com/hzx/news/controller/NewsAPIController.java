package com.hzx.news.controller;

import com.hzx.news.pojo.Cates;
import com.hzx.news.pojo.News;
import com.hzx.news.pojo.Response;
import com.hzx.news.services.NewsService;
import com.hzx.news.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class NewsAPIController {

    @Autowired
    NewsService newsServices;

    @RequestMapping("")
    public Response getNewsByCate(@RequestParam(value = "cate", required = true) int cate) {
        System.out.println(cate);
        List<News> list = newsServices.queryNewsByCate(cate);
        Response response = new Response(200, "请求成功", list.size(), true, list);
        return response;
    }

    @RequestMapping("/news")
    public Response getNewsByCateAndTime(@RequestParam(value = "cate") int cate, @RequestParam(value = "time") String time, int limit) {
        System.out.println(cate);
        String date = DateUtils.timeStamp2Date(time, "YYYY-MM-dd");
        System.out.println("日期为：" + date);
        List<News> list = newsServices.queryNewsByCateAndTime(cate, date, limit);
        Response response = new Response(200, "请求成功", list.size(), true, list);
        return response;
    }


    @RequestMapping("/cates")
    public Response getNewsCate() {
        List<Cates> list = newsServices.queryNewsCate();
        Response response = new Response(200, "请求成功", list.size(), true, list);
        return response;
    }
}
