package com.hzx.news.mapper;

import com.hzx.news.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SearchMapper {

    @Select("SELECT * FROM news WHERE abstract_title LIKE #{key} ")
    List<News> searchByKey(String key);
}
