package com.s11113153.databindingtest;

import com.s11113153.databindingtest.databinding.ActivityAvoidingNpeBinding;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by xuyouren on 15/6/6.
 */
public class AvoidingNullPointerExceptionActivity extends AppCompatActivity {

  public static void start(Context context) {
    Intent starter = new Intent(context, AvoidingNullPointerExceptionActivity.class);
    context.startActivity(starter);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityAvoidingNpeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_avoiding_npe);
    binding.setViewModel(null);
  }
}
