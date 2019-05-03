package com.hzx.news.services;

import com.hzx.news.mapper.SearchMapper;
import com.hzx.news.pojo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    SearchMapper searchMapper;

    public List<News> searchByKey(String key) {
        key = "%" + key + "%";
        List<News> list = searchMapper.searchByKey(key);
        return list;
    }
}
