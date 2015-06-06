package com.s11113153.databindingtest.activity;

import com.s11113153.databindingtest.R;
import com.s11113153.databindingtest.databinding.ActivitySimpleBinding;
import com.s11113153.databindingtest.model.User;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by xuyouren on 15/6/4.
 */
public class SimpleBindingActivity extends AppCompatActivity {

  public static void start(Context context) {
      Intent starter = new Intent(context, SimpleBindingActivity.class);
      context.startActivity(starter);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivitySimpleBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_simple);
    binding.setUser(new User()
        .setId(0)
        .setName("YouRen")
        .setDescription("Student"));

  }
}
