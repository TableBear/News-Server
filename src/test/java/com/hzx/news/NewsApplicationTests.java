package com.hzx.news;

import com.hzx.news.mapper.UserMapper;
import com.hzx.news.mapper.NewsMapper;
import com.hzx.news.pojo.User;
import com.hzx.news.utils.UUIDUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsApplicationTests {
    @Autowired
    NewsMapper newsMapper;
    @Autowired
    UserMapper userMapper;

    @Test
    public void contextLoads() {
//        List<News> news = newsMapper.getNewsByCateAndTime(0, "2019-04-04", 20);
//        System.out.println("数据长度：" + news.size());
//        Date date = new Date("2019-04-04");
//        String timeStamp = DateUtils.date2TimeStamp("2019-04-04 19:41:00", "yyyy-MM-dd HH:mm:ss");
//        System.out.println("test1:" + timeStamp);
//        String date = DateUtils.timeStamp2Date(timeStamp, "yyyy-MM-dd HH:mm:ss");
//        System.out.println("test2:" + date);
//        User user = new User();
//        user.setUnick("TableBear");
//        user.setPassword("123456");
//        int i = userMapper.saveUser(user);
//        System.out.println(i);
        User user = userMapper.queryUserByEmail("2390445347@qq.com");
        System.out.println(user);
        String uuid = UUIDUtils.getUUID();
        System.out.println(uuid);
    }


}
