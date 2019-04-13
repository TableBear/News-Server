package com.hzx.news.exception;

public class UnickIsNulllException extends RuntimeException {
    public UnickIsNulllException() {
        super("用户名不能为空");
    }
}
