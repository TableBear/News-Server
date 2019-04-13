package com.hzx.news.mapper;

import com.hzx.news.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordMapper {

    @Select("SELECT news.nid,article_type,abstract_title,title,article_url,crawl_time," +
            "keywords,cate,publish_time,author,cover_image_url,has_video,has_image,favorite_count,comments_count,content " +
            "FROM news  INNER   JOIN  news_log  ON news.nid=news_log.nid AND uid = #{uid}")
    List<News> queryHistory(String uid);

    @Select("SELECT news.nid,article_type,abstract_title,title,article_url,crawl_time," +
            "keywords,cate,publish_time,author,cover_image_url,has_video,has_image,favorite_count,comments_count,content " +
            "FROM news  INNER   JOIN  news_log  ON news.nid=news_log.nid AND uid = #{uid} AND is_collect=1")
    List<News> queryCollect(String uid);

    @Select("SELECT news.nid,article_type,abstract_title,title,article_url,crawl_time," +
            "keywords,cate,publish_time,author,cover_image_url,has_video,has_image,favorite_count,comments_count,content " +
            "FROM news  INNER   JOIN  news_log  ON news.nid=news_log.nid AND uid = #{uid} AND is_like=1")
    List<News> queryLike(String uid);

}
