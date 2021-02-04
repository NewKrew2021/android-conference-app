// Generated by data binding compiler. Do not edit!
package com.survivalcoding.ifkakao.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.survivalcoding.ifkakao.R;
import com.survivalcoding.ifkakao.ui.viewmodel.EventViewModel;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentSessionBinding extends ViewDataBinding {
  @NonNull
  public final AppBarLayout appbar;

  @NonNull
  public final ItemToolbarBinding include;

  @NonNull
  public final LinearLayout layoutSession;

  @NonNull
  public final RecyclerView rvVideoSession;

  @NonNull
  public final Toolbar toolbarSession;

  @NonNull
  public final VideoView videoViewSession;

  @Bindable
  protected EventViewModel mViewModel;

  protected FragmentSessionBinding(Object _bindingComponent, View _root, int _localFieldCount,
      AppBarLayout appbar, ItemToolbarBinding include, LinearLayout layoutSession,
      RecyclerView rvVideoSession, Toolbar toolbarSession, VideoView videoViewSession) {
    super(_bindingComponent, _root, _localFieldCount);
    this.appbar = appbar;
    this.include = include;
    this.layoutSession = layoutSession;
    this.rvVideoSession = rvVideoSession;
    this.toolbarSession = toolbarSession;
    this.videoViewSession = videoViewSession;
  }

  public abstract void setViewModel(@Nullable EventViewModel viewModel);

  @Nullable
  public EventViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static FragmentSessionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_session, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSessionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentSessionBinding>inflateInternal(inflater, R.layout.fragment_session, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentSessionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_session, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentSessionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentSessionBinding>inflateInternal(inflater, R.layout.fragment_session, null, false, component);
  }

  public static FragmentSessionBinding bind(@NonNull View view) {
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
  public static FragmentSessionBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentSessionBinding)bind(component, view, R.layout.fragment_session);
  }
}