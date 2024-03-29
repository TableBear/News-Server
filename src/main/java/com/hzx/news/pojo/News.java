package com.hzx.news.pojo;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "news", type = "news", shards = 1, replicas = 0)
public class News {
    @Id
    @Field(type = FieldType.Text)
    private String nid;
    @Field(type = FieldType.Integer)
    private int articleType;
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String abstractTitle;
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String title;
    @Field(type = FieldType.Text, index = false)
    private String articleUrl;
    @Field(type = FieldType.Date)
    private java.sql.Timestamp crawlTime;
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String keywords;
    @Field(type = FieldType.Integer)
    private int cate;
    @Field(type = FieldType.Date)
    private java.sql.Timestamp publishTime;
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String author;
    @Field(type = FieldType.Text, index = false)
    private String coverImageUrl;
    @Field(type = FieldType.Boolean)
    private boolean hasVideo;
    @Field(type = FieldType.Boolean)
    private boolean hasImage;
    @Field(type = FieldType.Long)
    private long favoriteCount;
    @Field(type = FieldType.Long)
    private long commentsCount;
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String content;


    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }


    public int getArticleType() {
        return articleType;
    }

    public void setArticleType(int articleType) {
        this.articleType = articleType;
    }


    public String getAbstractTitle() {
        return abstractTitle;
    }

    public void setAbstractTitle(String abstractTitle) {
        this.abstractTitle = abstractTitle;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }


    public java.sql.Timestamp getCrawlTime() {
        return crawlTime;
    }

    public void setCrawlTime(java.sql.Timestamp crawlTime) {
        this.crawlTime = crawlTime;
    }


    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }


    public int getCate() {
        return cate;
    }

    public void setCate(int cate) {
        this.cate = cate;
    }


    public java.sql.Timestamp getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(java.sql.Timestamp publishTime) {
        this.publishTime = publishTime;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }


    public boolean getHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(boolean hasVideo) {
        this.hasVideo = hasVideo;
    }


    public boolean getHasImage() {
        return hasImage;
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }


    public long getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(long favoriteCount) {
        this.favoriteCount = favoriteCount;
    }


    public long getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(long commentsCount) {
        this.commentsCount = commentsCount;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
