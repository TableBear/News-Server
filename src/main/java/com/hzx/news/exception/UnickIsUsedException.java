package com.hzx.news.exception;

public class UnickIsUsedException extends RuntimeException {
    public UnickIsUsedException() {
        super("用户名已被使用");
    }
}
