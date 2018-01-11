package com.fission.sample.asynctaskapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements MainView {

    private ImageView mIVDownloaded;
    private TextView mTVResult;
    private Button mBTStartDownload;
    private Presenter mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIVDownloaded = (ImageView)findViewById(R.id.iv_download);
        mTVResult = (TextView)findViewById(R.id.tv_result);
        mBTStartDownload = (Button)findViewById(R.id.btn_download);
        mPresenter = new PresenterImp(this);
        mBTStartDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.startDownloadImage();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.OnDestroy();
    }


    @Override
    public TextView getTextView() {
        return mTVResult;
    }

    @Override
    public ImageView getImageView() {
        return mIVDownloaded;
    }

    @Override
    public Button getButton() {
        return mBTStartDownload;
    }


}
