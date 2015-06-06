package com.s11113153.databindingtest.view_model;

import com.s11113153.databindingtest.model.Article;
import com.s11113153.databindingtest.model.User;

/**
 * Created by xuyouren on 15/6/6.
 */
public class AvoidingNullPointerExceptionViewModel {

  private User mUser;

  private Article mArticle;

  public User getUser() {
    return mUser;
  }

  public AvoidingNullPointerExceptionViewModel setUser(User user) {
    mUser = user;
    return this;
  }

  public Article getArticle() {
    return mArticle;
  }

  public AvoidingNullPointerExceptionViewModel setArticle(Article article) {
    mArticle = article;
    return this;
  }
}
