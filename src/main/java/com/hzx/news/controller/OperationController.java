package com.hzx.news.controller;

import com.hzx.news.annotation.UserLoginToken;
import com.hzx.news.services.NewsLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("opt")
public class OperationController {
    @Autowired
    NewsLogService newsLogService;

    @UserLoginToken
    @RequestMapping(value = "collect", method = RequestMethod.POST)
    public String collect(@RequestParam(value = "nid") String nid,
                          HttpServletResponse response) {
        
        if (newsLogService.isExistLog(uid, nid)) {

        }
        return "success";
    }

    @UserLoginToken
    @RequestMapping(value = "cancleCollect", method = RequestMethod.POST)
    public String cancleCollect(@RequestParam(value = "nid") String nid,
                                HttpServletResponse response) {
        if (newsLogService.isExistLog(uid, nid)) {

        } else {

        }
        return "success";
    }
}
