package com.hzx.news.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface NewsLogMapper {

    @Select("SELECT COUNT(*) FROM news_log WHERE nid=#{nid} AND uid=#{uid}")
    int isExistLog(String uid, String nid);

    @Update("UPDATE news_log SET is_collect=1 WHERE uid=#{uid} AND nid=#{nid}")
    int collect(String uid, String nid);

    @Update("UPDATE news_log SET is_collect=0 WHERE uid=#{uid} AND nid=#{nid}")
    int cancleCollect(String uid, String nid);

    @Update("UPDATE news_log SET is_like=1 WHERE uid=#{uid} AND nid=#{nid}")
    int like(String uid, String nid);

    @Update("UPDATE news_log SET is_like=0 WHERE uid=#{uid} AND nid=#{nid}")
    int cancleLike(String uid, String nid);

    @Update("UPDATE news_log SET is_click=1 WHERE uid=#{uid} AND nid=#{nid}")
    int click(String uid, String nid);

}
