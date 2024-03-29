package com.hzx.news.services;

import com.hzx.news.mapper.UserMapper;
import com.hzx.news.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public int register(User user) {
        int i = userMapper.saveUser(user);
        return i;
    }

    public User findUserByNick(String unick) {
        User user = userMapper.queryUserByNick(unick);
        return user;
    }

    public User findUserByUId(String uid) {
        User user = userMapper.queryUserByUId(uid);
        return user;
    }

    public boolean unickIsUsed(String unick) {
        int i = userMapper.queryUnickNum(unick);
        if (i > 0) {
            return true;
        }
        return false;
    }

    public boolean emailIsUsed(String email) {
        int i = userMapper.queryEmailNum(email);
        System.out.println(i);
        if (i > 0) {
            return true;
        }
        return false;
    }

    /**
     * @param email
     * @param password
     * @return
     * @descripe 用邮箱和密码进行登录
     */
    public User loginByEmailAndPassword(String email, String password) {
        User user = userMapper.queryUserByEmail(email, password);
        return user;
    }

    public void checkUser(User user) {
        userMapper.updateUserStatus(user);
    }

    public int updateUserNick(String nick, String uid) {
        int i = userMapper.updateUserNick(nick, uid);
        return i;
    }

    public int updateUserPhone(String phone, String uid) {
        int i = userMapper.updateUserPhone(phone, uid);
        return i;
    }

    public int updateUserQQ(String qq, String uid) {
        int i = userMapper.updateUserQQ(qq, uid);
        return i;
    }

    public int updateUserEmail(String email, String uid) {
        int i = userMapper.updateUserEmail(email, uid);
        return i;
    }

    public int updateUserPassword(String password, String uid) {
        int i = userMapper.updateUserPassword(password, uid);
        return i;
    }
}
