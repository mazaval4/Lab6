package com.example.mazaval4.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;



public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
//        WebView myWebView = (WebView) findViewById(R.id.webView);
//
//        myWebView.setWebViewClient(new WebViewClient());
//        myWebView.loadUrl("file:///android_asset/Clue.html");
//        WebSettings ws = myWebView.getSettings();
//        ws.setJavaScriptEnabled(true);
        nextPage();

    }
    public void nextPage(){
        final Button map_button = (Button)findViewById(R.id.button);
        map_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (HelloActivity.this, HelloActivity2.class);
                i.putExtra("name","miguel");
                startActivity(i);

            }
        });
    }
}
