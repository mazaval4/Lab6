package com.example.mazaval4.helloworld;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;


public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        nextPage();

        WebView webview = (WebView) findViewById(R.id.htmlRender);
        String summary = "<html><body><br><br><center>In the last game " +
                "name won after xxx rounds by guessing suspect in the room " +
                "with a weapon</center></body></html>";
        webview.loadData(summary, "text/html", null);

    }

    @Override
    public void onBackPressed() {

        Intent i = new Intent (HelloActivity.this, HelloActivity.class);
        startActivity(i);
        super.onBackPressed();
    }

    public void nextPage(){
        final Button button = (Button)findViewById(R.id.button);
        final EditText mEdit = (EditText) findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = mEdit.getText().toString();

                if(name.isEmpty())
                {
                    Context context = getApplicationContext();
                    CharSequence text = "Please enter a name!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                else{
                Intent i = new Intent (HelloActivity.this, HelloActivity2.class);
                i.putExtra("name",name);
                startActivity(i);
                }


            }


        });


    }
}
