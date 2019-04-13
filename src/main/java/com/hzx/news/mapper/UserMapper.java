package com.hzx.news.mapper;

import com.hzx.news.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("insert into user(unick,phone,qq,email,password) values(#{unick},#{phone},#{qq},#{email},#{password})")
    @Options(useGeneratedKeys = true, keyProperty = "uid")
    int saveUser(User user);

    @Select("SELECT COUNT(*) FROM `user` WHERE unick=#{unick}")
    int queryUnickNum(String unick);

    @Select("SELECT COUNT(*) FROM `user` WHERE email=#{email}")
    int queryEmailNum(String email);

    @Select("SELECT * FROM `user` WHERE email=#{email}")
    User queryUserByEmail(String email);

    @Select("SELECT * FROM `user` WHERE unick=#{unick}")
    User queryUserByNick(String unick);

    @Select("SELECT * FROM `user` WHERE uid=#{uid}")
    User queryUserByUId(String uid);

    @Update("UPDATE `user` SET `status`=1 WHERE unick=#{unick}")
    void updateUserStatus(User user);
}
