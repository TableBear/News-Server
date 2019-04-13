package com.hzx.news.exception;

public class EmailFormatException extends RuntimeException {
    public EmailFormatException() {
        super("邮箱格式错误");
    }
}
