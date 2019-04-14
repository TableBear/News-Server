package com.hzx.news.mapper;

import com.hzx.news.pojo.OptStatus;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Mapper
public interface NewsLogMapper {

    @Insert("INSERT INTO news_log(uid,nid,is_collect,last_action_time) VALUES(#{uid},#{nid},1,#{date}) ON DUPLICATE KEY UPDATE is_collect=1,last_action_time=#{date}")
    int collect(String uid, String nid, Date date);

    @Insert("INSERT INTO news_log(uid,nid,is_collect,last_action_time) VALUES(#{uid},#{nid},0,#{date}) ON DUPLICATE KEY UPDATE is_collect=0,last_action_time=#{date}")
    int cancleCollect(String uid, String nid, Date date);

    @Insert("INSERT INTO news_log(uid,nid,is_like,last_action_time) VALUES(#{uid},#{nid},1,#{date}) ON DUPLICATE KEY UPDATE is_like=1,last_action_time=#{date}")
    int like(String uid, String nid, Date date);

    @Insert("INSERT INTO news_log(uid,nid,is_like,last_action_time) VALUES(#{uid},#{nid},0,#{date}) ON DUPLICATE KEY UPDATE is_like=0,last_action_time=#{date}")
    int cancleLike(String uid, String nid, Date date);

    @Insert("INSERT INTO news_log(uid,nid,is_click,last_action_time) VALUES(#{uid},#{nid},1,#{date}) ON DUPLICATE KEY UPDATE is_click=1,last_action_time=#{date}")
    int click(String uid, String nid, Date date);

    @Select("SELECT is_like,is_collect FROM news_log WHERE nid=#{nid} AND uid=#{uid}")
    OptStatus queryLikeAndCollect(String uid, String nid);

}
