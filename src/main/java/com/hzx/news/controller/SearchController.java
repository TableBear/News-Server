package com.hzx.news.controller;

import com.hzx.news.pojo.News;
import com.hzx.news.pojo.Response;
import com.hzx.news.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("search")
public class SearchController {

    @Autowired
    SearchService searchService;

    @RequestMapping("key")
    public Response searchByKey(String key) {
        List<News> list = searchService.searchByKey(key);
        Response response = new Response(200, "请求成功", list.size(), true, list);
        return response;
    }
}
