package com.s11113153.databindingtest.activity;

import com.s11113153.databindingtest.R;
import com.s11113153.databindingtest.databinding.ActivityViewsWithIdsBinding;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by xuyouren on 15/6/5.
 */
public class ViewsWithIDsActivity extends AppCompatActivity {

  public static void start(Context context) {
    Intent starter = new Intent(context, ViewsWithIDsActivity.class);
    context.startActivity(starter);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActivityViewsWithIdsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_views_with_ids);

    binding.tvName.setText("YouRen");
    binding.tvDescription.setText("content");
    binding.buttonOk.setText("Ok");
    binding.buttonOk.setOnClickListener( (View v) -> {
      String content = ((TextView)v).getText().toString();
      Toast.makeText(ViewsWithIDsActivity.this, String.valueOf(content), Toast.LENGTH_SHORT).show();
    });
  }
}
