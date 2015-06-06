package com.s11113153.databindingtest;

import com.s11113153.databindingtest.databinding.ActivityIncludeBinding;
import com.s11113153.databindingtest.model.User;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by xuyouren on 15/6/6.
 */
public class IncludeDataBindingLayoutActivity extends AppCompatActivity {


  public static void start(Context context) {
    Intent starter = new Intent(context, IncludeDataBindingLayoutActivity.class);
    context.startActivity(starter);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    User user = new User()
      .setId(99)
      .setName("MNC")
      .setDescription("Andoid M is Macadamia Nut Cookie ?");

    ActivityIncludeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_include);
    binding.setUser(user);
  }
}
