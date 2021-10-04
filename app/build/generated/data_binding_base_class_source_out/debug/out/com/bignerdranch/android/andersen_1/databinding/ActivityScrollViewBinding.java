// Generated by view binder compiler. Do not edit!
package com.bignerdranch.android.andersen_1.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bignerdranch.android.andersen_1.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityScrollViewBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView article;

  @NonNull
  public final TextView articleSubheading;

  @NonNull
  public final Button buttonToMainActivity;

  @NonNull
  public final Button buttonToTwoActivity;

  @NonNull
  public final TextView textRelativeLayout;

  @NonNull
  public final TextView titleOfScrollview;

  private ActivityScrollViewBinding(@NonNull RelativeLayout rootView, @NonNull TextView article,
      @NonNull TextView articleSubheading, @NonNull Button buttonToMainActivity,
      @NonNull Button buttonToTwoActivity, @NonNull TextView textRelativeLayout,
      @NonNull TextView titleOfScrollview) {
    this.rootView = rootView;
    this.article = article;
    this.articleSubheading = articleSubheading;
    this.buttonToMainActivity = buttonToMainActivity;
    this.buttonToTwoActivity = buttonToTwoActivity;
    this.textRelativeLayout = textRelativeLayout;
    this.titleOfScrollview = titleOfScrollview;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityScrollViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityScrollViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_scroll_view, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityScrollViewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.article;
      TextView article = ViewBindings.findChildViewById(rootView, id);
      if (article == null) {
        break missingId;
      }

      id = R.id.article_subheading;
      TextView articleSubheading = ViewBindings.findChildViewById(rootView, id);
      if (articleSubheading == null) {
        break missingId;
      }

      id = R.id.button_to_main_activity;
      Button buttonToMainActivity = ViewBindings.findChildViewById(rootView, id);
      if (buttonToMainActivity == null) {
        break missingId;
      }

      id = R.id.button_to_two_activity;
      Button buttonToTwoActivity = ViewBindings.findChildViewById(rootView, id);
      if (buttonToTwoActivity == null) {
        break missingId;
      }

      id = R.id.textRelativeLayout;
      TextView textRelativeLayout = ViewBindings.findChildViewById(rootView, id);
      if (textRelativeLayout == null) {
        break missingId;
      }

      id = R.id.title_of_scrollview;
      TextView titleOfScrollview = ViewBindings.findChildViewById(rootView, id);
      if (titleOfScrollview == null) {
        break missingId;
      }

      return new ActivityScrollViewBinding((RelativeLayout) rootView, article, articleSubheading,
          buttonToMainActivity, buttonToTwoActivity, textRelativeLayout, titleOfScrollview);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
