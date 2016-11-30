package com.example.mazaval4.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HelloActivity2 extends AppCompatActivity {


    private static final String URL = "file:///android_asset/Clue.html";
    private WebView myWebView;
    static String name ="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello2);
        myWebView = (WebView) findViewById(R.id.webView);

        Intent i = getIntent();
        name = i.getExtras().getString("name");
        name = Character.toUpperCase(name.charAt(0)) + name.substring(1);


        if(name.isEmpty())
        {
           finish();
        }

        myWebView.getSettings().setJavaScriptEnabled(true);

        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url)
            {
                myWebView.loadUrl("javascript:getUserName(\"" + name + "\")");
            }
        });
        myWebView.loadUrl(URL);

        myWebView.addJavascriptInterface(new Object()
        {
            @android.webkit.JavascriptInterface
            public void performClick(String temp){
                Intent tired = new Intent(HelloActivity2.this,HelloActivity.class);
                tired.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(tired);
            }
        },"cont");


    }


}



