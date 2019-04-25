package com.hzx.news.mapper;

import com.hzx.news.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecommendMapper {

    @Select("SELECT news.nid,article_type,abstract_title,title,article_url,crawl_time,keywords,cate,publish_time,author,cover_image_url,has_video,has_image,favorite_count,comments_count,content FROM news_recom LEFT JOIN news ON news_recom.nid=news.nid WHERE uid=#{uid} LIMIT #{offest}, #{limit}")
    List<News> getRecomNews(String uid, int offest, int limit);
}
