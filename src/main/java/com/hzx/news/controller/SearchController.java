package com.hzx.news.controller;

import com.hzx.news.mapper.MyResultMapper;
import com.hzx.news.mapper.NewsRepository;
import com.hzx.news.pojo.News;
import com.hzx.news.pojo.Response;
import com.hzx.news.services.NewsService;
import com.hzx.news.services.SearchService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("search")
public class SearchController {

    @Autowired
    NewsRepository newsRepository; //ES JPA 类
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate; //ES　工具类
    @Autowired
    NewsService newsService;
    @Autowired
    MyResultMapper myResultMapper;

    @RequestMapping("key")
    public Response searchByKey(String key) {
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery()
                .should(QueryBuilders.matchPhraseQuery("author", key))
                .should(QueryBuilders.matchPhraseQuery("title", key))
                .should(QueryBuilders.matchPhraseQuery("abstractTitle", key))
                .should(QueryBuilders.matchPhraseQuery("content", key));
        HighlightBuilder.Field highlightAuthor = new HighlightBuilder.Field("author").preTags("<span style=\"color:red;\">").postTags("</span>");
        HighlightBuilder.Field highlightTitle = new HighlightBuilder.Field("title").preTags("<span style=\"color:red;\">").postTags("</span>");
        HighlightBuilder.Field highlightAbstractTitle = new HighlightBuilder.Field("abstractTitle").preTags("<span style=\"color:red;\">").postTags("</span>");
        HighlightBuilder.Field highlightContent = new HighlightBuilder.Field("content").preTags("<span style=\"color:red;\">").postTags("</span>");
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withHighlightFields(highlightAuthor, highlightTitle, highlightAbstractTitle, highlightContent)
                .build();
        Page<News> newsPage = elasticsearchTemplate.queryForPage(searchQuery, News.class, myResultMapper);
        List<News> list = newsPage.getContent();
        for (News news : newsPage.getContent()) {
            System.out.println(news);
        }
        Response response = new Response(200, "请求成功", list.size(), true, list);
        return response;
    }

    @RequestMapping("add")
    public String addNewsToIndex() {
        List<News> list = newsService.queryAllNews();
        newsRepository.saveAll(list);
        return "success";
    }

    @RequestMapping("delete")
    public String deleteAllNewsInIndex() {
        newsRepository.deleteAll();
        return "success";
    }
}
