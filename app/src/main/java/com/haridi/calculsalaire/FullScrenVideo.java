package com.haridi.calculsalaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.ArrayList;

public class FullScrenVideo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fullscrenvideo);

        WebView videoWeb;

        Bundle bundle = getIntent().getExtras();
        videoWeb = (WebView) findViewById(R.id.videoWebView);

        if (bundle != null) {
            // Showing progress dialog.
            Intent i = getIntent();

            int mPosition = bundle.getInt("pos");
           String newString= bundle.getString("video");
                  System.out.println("newString  :" + newString);
            WebSettings webSettings = videoWeb.getSettings();
            webSettings.setJavaScriptEnabled(true);
            videoWeb.loadData(newString, "text/html", "utf-8");
//            videoWeb.loadData(newString , "text/html" , "utf-8" );
//            videoWeb.setWebChromeClient(new WebChromeClient() {
//            } );



        }
    }



}
