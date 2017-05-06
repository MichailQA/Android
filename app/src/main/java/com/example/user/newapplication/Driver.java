package com.example.user.newapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Driver extends AppCompatActivity implements View.OnTouchListener {

    ImageButton btnUp;
    ImageButton btnDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driver);

        Intent intent = getIntent();

        String ip = intent.getStringExtra("IP");
        Integer port = intent.getIntExtra("Port", 8080);

        boolean dirRBStatus = intent.getBooleanExtra("Direct radio button status", false);
        boolean remRBStatus = intent.getBooleanExtra("Remote radio button status", false);

        ServerConnection connect = new ServerConnection(ip, port, dirRBStatus, remRBStatus);

        btnUp = (ImageButton) findViewById(R.id.btnUp);
        btnDown = (ImageButton) findViewById(R.id.btnDown);

        btnUp.setOnTouchListener(this);
        btnDown.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        ImageButton btn = (ImageButton) v;
        String way;
        if(btn.getId()==R.id.btnDown){
            way = "Down";
        }else{
            way = "Up";
        }
        TextView textView = (TextView) findViewById(R.id.text_field);
        if(event.getAction() == MotionEvent.ACTION_DOWN){

            textView.setText("Button "+way+" Pressed");
        }
        if(event.getAction() == MotionEvent.ACTION_UP){
            textView.setText(""); //finger was lifted
        }
        return true;
    }
}
