package com.hajiren.bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Blog {

    private String id;
    private String title;
    private String cover;
    private String avatar;
    private String author;
    private Date date;
    private String categories;
    private String summary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    private List<String> articles[];

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String>[] getArticles() {
        return articles;
    }

    public void setArticles(List<String>[] articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", avatar='" + avatar + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", categories='" + categories + '\'' +
                ", summary='" + summary + '\'' +
                ", articles=" + Arrays.toString(articles) +
                '}';
    }
}
