package com.hzx.news.services;

import com.hzx.news.mapper.NewsLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsLogService {
    @Autowired
    NewsLogMapper newsLogMapper;

    public boolean isExistLog(String uid, String nid) {
        int i = newsLogMapper.isExistLog(uid, nid);
        if (i > 0) {
            return true;
        }
        return false;
    }
}
