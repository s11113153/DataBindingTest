package com.s11113153.databindingtest.api;

import com.s11113153.databindingtest.model.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;

/**
 * Created by xuyouren on 15/6/6.
 */
public class ArticleApiClient {

  private static final int RANDOM_SUCCESSFUL = 0;
  private static final int RANDOM_FAILURE = 1;

  public Observable<List<Article>> getData() {
    return
      Observable
        .create((Subscriber<? super List<Article>> subscriber) -> {
          Random random = new Random();

           // generate (0 ~ 1)
          if (random.nextInt(2) == RANDOM_FAILURE) {
            subscriber.onError(new Exception("generating random is failure"));
            return;
          }

          final List<Article> articles = new ArrayList<>();

          Observable
            .range(0, 20)
            .subscribe(
              (Integer index) -> {
                articles.add(
                  new Article()
                    .setId(index)
                    .setTitle("title[" + index + "]")
                    .setDescription("description:" + index)
                    .setUrl("http://developer.android.com/tools/data-binding/guide.html")
                );

                subscriber.onNext(articles);
                subscriber.onCompleted();
              }
            );

        }).delay(2, TimeUnit.SECONDS);
  }
}
