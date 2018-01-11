package com.fission.sample.asynctaskapp;

import android.graphics.Bitmap;
import android.view.View;

/**
 * @author lakshmi on 3/3/17.
 */

public class PresenterImp implements Presenter{

    private MainView mMainView;

    public PresenterImp(MainView mainView){
        this.mMainView = mainView;

    }
    @Override
    public void startDownloadImage() {
       // String url = "http://api.androidhive.info/images/sample.jpg";
        String url = "https://www.pexels.com/photo/white-and-yellow-flower-with-green-stems-36764/";
        mMainView.getButton().setVisibility(View.GONE);
        new MyAsynckTask().execute(url,mMainView.getImageView(),mMainView.getTextView());

    }

    @Override
    public void OnDestroy() {
        mMainView = null;
    }


}
