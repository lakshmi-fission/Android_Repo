package com.fission.sample.asynctaskapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * @author lakshmi on 3/3/17.
 */

public class MyAsynckTask extends AsyncTask<Object,Void,Bitmap>{

    private ImageView imageView = null;
    private TextView textView = null;
    private String url = null;
    @Override
    protected Bitmap doInBackground(Object... objects) {
        for(Object param :objects){
            if(param instanceof ImageView){
                this.imageView = (ImageView)param;
            }
            else if(param instanceof TextView){
                this.textView = (TextView)param;
            }
            else if (param instanceof String){
                this.url = (String)param;
            }
        }
        return downloadImage(url);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);
        textView.setText(R.string.msg_result);

    }
    private Bitmap downloadImage(String downloadUrl){
        //Bitmap resizedBitmap = null;
        Bitmap bitmap = null;
        try {
            //Bitmap bitmap;
            int newHeight = 200 ;
            int newWidth = 200;
            URL url = new URL(downloadUrl);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            Log.e("A","inputStream"+inputStream);
            bitmap = BitmapFactory.decodeStream(inputStream);
           /* int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float scaleWidth = ((float) newWidth) / width;
            float scaleHeight = ((float) newHeight) / height;
            Matrix matrix = new Matrix();
            matrix.postScale(scaleWidth, scaleHeight);
            resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);*/
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

}
