package com.hzx.news.mapper;

import com.hzx.news.pojo.Cates;
import com.hzx.news.pojo.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsMapper {
    /**
     * @param cate
     * @return a list of news
     */
    @Select("select * FROM news where cate=#{cate} order by publish_time desc limit 10")
    List<News> getNewsByCate(int cate);

    @Select("select * FROM cates")
    List<Cates> getNewsCate();

    @Select("select * FROM news where cate=#{cate} and publish_time<#{date} order by publish_time desc limit #{limit}")
    List<News> getNewsByCateAndTime(int cate, String date, int limit);

    @Select("select * FROM news where publish_time<#{date} order by by publish_time desc limit #{limit}")
    List<News> getNews(String date, int limit);

    @Select("SELECT * FROM news LIMIT #{offest},#{limit}")
    List<News> getNewsByOffest(int offest, int limit);

    @Select("SELECT * FROM news")
    List<News> getAllNews();
}
