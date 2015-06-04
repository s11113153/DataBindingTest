package com.s11113153.databindingtest;

import com.s11113153.databindingtest.databinding.ActivityAutoUpdateBinding;
import com.s11113153.databindingtest.model.User;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by xuyouren on 15/6/4.
 */
public class AutoUpdateBindingActivity extends AppCompatActivity {

  public static void start(Context context) {
    Intent starter = new Intent(context, AutoUpdateBindingActivity.class);
    context.startActivity(starter);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ActivityAutoUpdateBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_auto_update);

    User user = new User()
      .setId(0)
      .setName("YouRen")
      .setDescription("Research Student");

    binding.setUser(user);

    binding.setTextColor(Color.parseColor("#ff0000"));
    binding.textInput.setText(user.getName());
    binding.textInput.addTextChangedListener(new TextWatcher() {
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count, int after) {

      }

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {

      }

      @Override
      public void afterTextChanged(Editable s) {
        user.setName(s.toString());
      }
    });

  }
}
