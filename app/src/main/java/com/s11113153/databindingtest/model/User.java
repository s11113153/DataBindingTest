package com.s11113153.databindingtest.model;

import com.s11113153.databindingtest.BR;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by xuyouren on 15/6/4.
 */
public class User extends BaseObservable{

  private long id;

  private String name;

  private String description;

  /** auto setter **/

  public User setId(long id) {
    this.id = id;
    return this;
  }

  public User setName(String name) {
    this.name = name;
    return this;
  }

  public User setDescription(String description) {
    this.description = description;
    return this;
  }

  /** auto getter **/

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }
}
