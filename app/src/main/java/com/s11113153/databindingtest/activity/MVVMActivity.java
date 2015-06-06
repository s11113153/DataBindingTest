package com.s11113153.databindingtest.activity;

import com.s11113153.databindingtest.R;
import com.s11113153.databindingtest.api.ArticleApiClient;
import com.s11113153.databindingtest.databinding.ActivityMmvmBinding;
import com.s11113153.databindingtest.model.Article;
import com.s11113153.databindingtest.view_model.ArticleListViewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by xuyouren on 15/6/6.
 */
public class MVVMActivity extends AppCompatActivity {

  private static final String TAG = MVVMActivity.class.getSimpleName();

  public static void start(Context context) {
    Intent starter = new Intent(context, MVVMActivity.class);
    context.startActivity(starter);
  }

  private Subscription mSubscription = Subscriptions.empty();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ArticleApiClient apiClient = new ArticleApiClient();
    ArticleListViewModel model = new ArticleListViewModel(this);
    ActivityMmvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mmvm);

    binding.setModel(model);

    mSubscription = apiClient.getData()
      .subscribeOn(Schedulers.io())
      .observeOn(AndroidSchedulers.mainThread())
      .subscribe(
        (List<Article> articles) -> {
          model.setArticles(articles);
        },
        (Throwable throwable) -> {
          model.setShowError(true);
          Log.e(TAG, throwable.toString());
        }
      );
  }

  @Override
  protected void onPause() {
    super.onPause();
    mSubscription.unsubscribe();
    if (mSubscription.isUnsubscribed()) {
      Log.e(TAG, "subscription is onsubscribe");
    }
  }
}
