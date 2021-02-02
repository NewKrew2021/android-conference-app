// Generated by data binding compiler. Do not edit!
package com.survivalcoding.ifkakao.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.survivalcoding.ifkakao.R;
import com.survivalcoding.ifkakao.ui.viewmodel.MainViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentMainBinding extends ViewDataBinding {
  @NonNull
  public final Button btnAllSessionMain;

  @NonNull
  public final ItemToolbarBinding include;

  @NonNull
  public final ImageView ivTitlePosterMain;

  @NonNull
  public final ImageButton ivUpScrollMain;

  @NonNull
  public final RecyclerView rvVideoMain;

  @NonNull
  public final ScrollView svMain;

  @NonNull
  public final TextView tvHighlightMain;

  @NonNull
  public final TextView tvKakaoCorpMain;

  @Bindable
  protected MainViewModel mViewModel;

  protected FragmentMainBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button btnAllSessionMain, ItemToolbarBinding include, ImageView ivTitlePosterMain,
      ImageButton ivUpScrollMain, RecyclerView rvVideoMain, ScrollView svMain,
      TextView tvHighlightMain, TextView tvKakaoCorpMain) {
    super(_bindingComponent, _root, _localFieldCount);
    this.btnAllSessionMain = btnAllSessionMain;
    this.include = include;
    this.ivTitlePosterMain = ivTitlePosterMain;
    this.ivUpScrollMain = ivUpScrollMain;
    this.rvVideoMain = rvVideoMain;
    this.svMain = svMain;
    this.tvHighlightMain = tvHighlightMain;
    this.tvKakaoCorpMain = tvKakaoCorpMain;
  }

  public abstract void setViewModel(@Nullable MainViewModel viewModel);

  @Nullable
  public MainViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static FragmentMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_main, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentMainBinding>inflateInternal(inflater, R.layout.fragment_main, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_main, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentMainBinding>inflateInternal(inflater, R.layout.fragment_main, null, false, component);
  }

  public static FragmentMainBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentMainBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentMainBinding)bind(component, view, R.layout.fragment_main);
  }
}
