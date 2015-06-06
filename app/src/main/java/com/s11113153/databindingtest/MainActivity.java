package com.s11113153.databindingtest;

import com.s11113153.databindingtest.databinding.ActivityMainBinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import rx.functions.Action0;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    final TitleAdapter adapter = new TitleAdapter(this);

    adapter
      .addTitle(new Title("Simple Binding", ()-> SimpleBindingActivity.start(this)))

      .addTitle(new Title("Auto Update", ()-> AutoUpdateBindingActivity.start(this)))

      .addTitle(new Title("View With IDs", ()-> ViewsWithIDsActivity.start(this)))

      .addTitle(new Title("MVVM Pattern", ()-> MVVMActivity.start(this)))

      .addTitle(new Title("Avoiding NullPointerException", ()-> AvoidingNullPointerExceptionActivity.start(this)))

      .addTitle(new Title("Include Data Binding Layout", ()-> {}));

    binding.setListOnItemClickListener((AdapterView<?> parent, View view, int position, long id) ->
        adapter.getItem(position).action.call()
    );

    binding.listItem.setAdapter(adapter);
  }

  private class Title {

    private String title;

    private Action0 action;

    public Title(String title, Action0 action) {
      this.title = title;
      this.action = action;
    }
  }

  private class TitleAdapter extends ArrayAdapter<Title> {
    private static final int ITEM_TYPE_TextView = 0;

    public TitleAdapter(Context context) {
      super(context, android.R.layout.simple_list_item_1, android.R.id.text1);
    }

    @Override
    public int getItemViewType(int position) {
      return ITEM_TYPE_TextView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      if (getItemViewType(position) != ITEM_TYPE_TextView) return null;

      TextView tv = (TextView)super.getView(position, convertView, parent);
      String title = getItem(position).title;
      tv.setText(title);
      return tv;
    }

    public TitleAdapter addTitle(Title object) {
      super.add(object);
      return this;
    }
  }
}
