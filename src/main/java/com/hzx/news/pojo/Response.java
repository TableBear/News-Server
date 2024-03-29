package com.hzx.news.pojo;

import java.util.List;

public class Response {
    private int code;
    private String msg;
    private int total_num;
    private boolean has_more;
    private List<Object> list;

    public Response() {
    }

    public Response(int code, String msg, int total_num, boolean has_more, List list) {
        this.code = code;
        this.msg = msg;
        this.total_num = total_num;
        this.has_more = has_more;
        this.list = list;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotal_num() {
        return total_num;
    }

    public void setTotal_num(int total_num) {
        this.total_num = total_num;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
