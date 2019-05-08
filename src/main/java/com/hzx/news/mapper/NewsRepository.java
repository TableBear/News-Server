package com.hzx.news.mapper;

import com.hzx.news.pojo.News;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

@Configuration
public interface NewsRepository extends ElasticsearchRepository<News, String> {
}
