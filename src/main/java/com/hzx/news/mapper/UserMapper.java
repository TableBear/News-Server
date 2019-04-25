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

    @Select("SELECT * FROM `user` WHERE email=#{email} And password=#{password}")
    User queryUserByEmail(String email, String password);

    @Select("SELECT * FROM `user` WHERE unick=#{unick}")
    User queryUserByNick(String unick);

    @Select("SELECT * FROM `user` WHERE uid=#{uid}")
    User queryUserByUId(String uid);

    @Update("UPDATE `user` SET `status`=1 WHERE unick=#{unick}")
    void updateUserStatus(User user);

    @Update("UPDATE `user` SET unick=#{unick} WHERE uid=#{uid}")
    int updateUserNick(String unick,String uid);

    @Update("UPDATE `user` SET phone=#{phone} WHERE uid=#{uid}")
    int updateUserPhone(String phone,String uid);

    @Update("UPDATE `user` SET qq=#{qq} WHERE uid=#{uid}")
    int updateUserQQ(String qq,String uid);

    @Update("UPDATE `user` SET email=#{email} WHERE uid=#{uid}")
    int updateUserEmail(String email,String uid);

    @Update("UPDATE `user` SET password=#{password} WHERE uid=#{uid}")
    int updateUserPassword(String password,String uid);
}
