package com.example.mazaval4.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HelloActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello2);

        WebView myWebView = (WebView) findViewById(R.id.webView);
        Intent i = getIntent();
        String name = i.getExtras().getString("name");
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("file:///android_asset/Clue.html");
        WebSettings ws = myWebView.getSettings();
        ws.setJavaScriptEnabled(true);

    }
}
