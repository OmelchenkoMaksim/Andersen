// Generated by view binder compiler. Do not edit!
package com.bignerdranch.android.andersen_1.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.bignerdranch.android.andersen_1.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityTwoActivitiesAndIntentsBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonToSecondActivity;

  @NonNull
  public final EditText messageForSentToSecond;

  @NonNull
  public final TextView textHeader;

  @NonNull
  public final TextView textMessageReplied;

  private ActivityTwoActivitiesAndIntentsBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button buttonToSecondActivity, @NonNull EditText messageForSentToSecond,
      @NonNull TextView textHeader, @NonNull TextView textMessageReplied) {
    this.rootView = rootView;
    this.buttonToSecondActivity = buttonToSecondActivity;
    this.messageForSentToSecond = messageForSentToSecond;
    this.textHeader = textHeader;
    this.textMessageReplied = textMessageReplied;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTwoActivitiesAndIntentsBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTwoActivitiesAndIntentsBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_two_activities_and_intents, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTwoActivitiesAndIntentsBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_to_second_activity;
      Button buttonToSecondActivity = ViewBindings.findChildViewById(rootView, id);
      if (buttonToSecondActivity == null) {
        break missingId;
      }

      id = R.id.message_for_sent_to_second;
      EditText messageForSentToSecond = ViewBindings.findChildViewById(rootView, id);
      if (messageForSentToSecond == null) {
        break missingId;
      }

      id = R.id.text_header;
      TextView textHeader = ViewBindings.findChildViewById(rootView, id);
      if (textHeader == null) {
        break missingId;
      }

      id = R.id.text_message_replied;
      TextView textMessageReplied = ViewBindings.findChildViewById(rootView, id);
      if (textMessageReplied == null) {
        break missingId;
      }

      return new ActivityTwoActivitiesAndIntentsBinding((ConstraintLayout) rootView,
          buttonToSecondActivity, messageForSentToSecond, textHeader, textMessageReplied);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
