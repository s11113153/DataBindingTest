package com.s11113153.databindingtest.view_model;

import com.s11113153.databindingtest.BR;
import com.s11113153.databindingtest.adapter.ArticleAdapter;
import com.s11113153.databindingtest.model.Article;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;

/**
 * Created by xuyouren on 15/6/6.
 */
public class ArticleListViewModel
  extends BaseObservable
  implements AdapterView.OnItemClickListener {

  private static final String TAG = ArticleListViewModel.class.getSimpleName();

  Context context;

  private List<Article> articles;

  private ArticleAdapter adapter;

  private boolean showContent;

  private boolean showError;


  public ArticleListViewModel(Context context) {
    this.context = context;
    this.adapter = new ArticleAdapter(context);
    Log.e(TAG, "init showContent: " + showContent);
    Log.e(TAG, "init showError: " + showError);
  }

  public List<Article> getArticles() {
    return articles;
  }

  public void setArticles(List<Article> articles) {
    this.articles = articles;
    adapter.clear();
    adapter.addAll(this.articles);
    setAdapter(adapter);
  }

  public ArticleAdapter getAdapter() {
    return adapter;
  }

  public void setAdapter(ArticleAdapter adapter) {
    Log.e(TAG, "setAdapter");
    this.adapter = adapter;
    setShowContent(adapter.getCount() > 0);
  }


  @Bindable
  public boolean isShowContent() {
    return showContent;
  }

  public void setShowContent(boolean showContent) {
    Log.e(TAG, "setShoeContent: " + showContent);
    this.showContent = showContent;
    notifyPropertyChanged(BR.showContent);
  }

  @Bindable
  public boolean isShowError() {
    return showError;
  }

  public void setShowError(boolean showError) {
    this.showError = showError;
    setShowContent(!showError);
    notifyPropertyChanged(BR.showError);
  }

  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    String url = getArticles().get(position).getUrl();
    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    context.startActivity(intent);
  }
}
