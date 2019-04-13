package com.hzx.news.exception;

public class PasswordException extends RuntimeException {

    public PasswordException() {
        super("密码格式不符合");
    }
}
