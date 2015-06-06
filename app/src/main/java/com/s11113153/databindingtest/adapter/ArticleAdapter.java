package com.s11113153.databindingtest.adapter;

import com.s11113153.databindingtest.ArticleBinding;
import com.s11113153.databindingtest.model.Article;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by xuyouren on 15/6/6.
 */
public class ArticleAdapter extends ArrayAdapter<Article> {

  public ArticleAdapter(Context context) {
    super(context, 0);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
      ArticleBinding binding = ArticleBinding.inflate(LayoutInflater.from(getContext()));
      convertView = binding.getRoot();
      convertView.setTag(binding);
    }
    ((ArticleBinding)convertView.getTag()).setArticleItem(getItem(position));
    return convertView;
  }
}
