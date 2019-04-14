package com.hzx.news.services;

import com.hzx.news.mapper.NewsLogMapper;
import com.hzx.news.pojo.OptStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NewsLogService {
    @Autowired
    NewsLogMapper newsLogMapper;

    public void collect(String uid, String nid, Date date) {
        System.out.println(date);
        newsLogMapper.collect(uid, nid, date);
    }

    public void cancleCollect(String uid, String nid, Date date) {
        newsLogMapper.cancleCollect(uid, nid, date);
    }

    public void like(String uid, String nid, Date date) {
        newsLogMapper.like(uid, nid, date);
    }

    public void cancleLike(String uid, String nid, Date date) {
        newsLogMapper.cancleLike(uid, nid, date);
    }

    public void click(String uid, String nid, Date date) {
        newsLogMapper.click(uid, nid, date);
    }

    public OptStatus getStatus(String uid, String nid) {
        OptStatus likeAndCollect = newsLogMapper.queryLikeAndCollect(uid, nid);
        return likeAndCollect;
    }

}
