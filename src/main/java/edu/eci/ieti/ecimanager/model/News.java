package edu.eci.ieti.ecimanager.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "news")
public class News {
    @Id
    private String id;
    private String url;
    private String title;
    private String content;
    private Date publishingDate;
    private String picture;
    private String author;

    public News(String id, String url, String title, String content, Date publishingDate, String picture, String author) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.content = content;
        this.publishingDate = publishingDate;
        this.picture = picture;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getPublishingDate() {
        return publishingDate;
    }

    public String getPicture() {
        return picture;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPublishingDate(Date publishingDate) {
        this.publishingDate = publishingDate;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}