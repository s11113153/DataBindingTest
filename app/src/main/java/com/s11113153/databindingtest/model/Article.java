package com.s11113153.databindingtest.model;

/**
 * Created by xuyouren on 15/6/6.
 */
public class Article {

  private long id;

  private String title;

  private String description;

  private String url;

  public long getId() {
    return id;
  }

  public Article setId(long id) {
    this.id = id;
    return this;
  }

  public String getTitle() {
    return title;
  }

  public Article setTitle(String title) {
    this.title = title;
    return this;
  }

  public String getDescription() {
    return description;
  }

  public Article setDescription(String description) {
    this.description = description;
    return this;
  }

  public String getUrl() {
    return url;
  }

  public Article setUrl(String url) {
    this.url = url;
    return this;
  }
}
