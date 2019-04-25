package com.hzx.news.services;

import com.hzx.news.mapper.RecommendMapper;
import com.hzx.news.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendService {
    @Autowired
    RecommendMapper recommendMapper;

    public List<News> queryRecommendNews(String uid, int offest, int limit) {
        List<News> list = recommendMapper.getRecomNews(uid, offest, limit);
        return list;
    }
}
