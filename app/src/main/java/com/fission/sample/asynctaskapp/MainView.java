package com.fission.sample.asynctaskapp;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author lakshmi on 3/3/17.
 */

public interface MainView {
    TextView getTextView();
    ImageView getImageView();
    Button getButton();
}
