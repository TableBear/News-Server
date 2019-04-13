package com.hzx.news.pojo;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.hzx.news.utils.UUIDUtils;

public class User {

    private long uid;
    private String unick;
    private String phone;
    private String qq;
    private String email;
    private String password;
    private long status;


    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }


    public String getUnick() {
        return unick;
    }

    public void setUnick(String unick) {
        this.unick = unick;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }


    public String getToken() {
        String token = JWT.create().withAudience("" + getUid())
                .sign(Algorithm.HMAC256(getPassword()));
        return token;
    }

}
