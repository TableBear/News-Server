package com.hzx.news.exception;

public class EmailIsUsedException extends RuntimeException {

    public EmailIsUsedException() {
        super("邮箱已被注册");
    }
}
