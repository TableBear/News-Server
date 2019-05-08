package com.hzx.news.services;

import com.hzx.news.pojo.Cates;
import com.hzx.news.pojo.News;
import com.hzx.news.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    NewsMapper newsMapper;

    public List<News> queryNewsByCate(int cate) {
        List<News> list = newsMapper.getNewsByCate(cate);
        return list;
    }

    public List<News> queryNewsByCateAndTime(int cate, String date, int limit) {
        List<News> list = newsMapper.getNewsByCateAndTime(cate, date, limit);
        return list;
    }

    public List<Cates> queryNewsCate() {
        List<Cates> list = newsMapper.getNewsCate();
        return list;
    }

    public List<News> queryAllNewsByTime(String date, int limit) {
        List<News> list = newsMapper.getNews(date, limit);
        return list;
    }

    public List<News> queryAllNewsByOffest(int offest, int limit) {
        List<News> list = newsMapper.getNewsByOffest(offest, limit);
        return list;
    }

    public List<News> queryAllNews() {
        List<News> list = newsMapper.getAllNews();
        return list;
    }
}
