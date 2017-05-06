package com.example.user.newapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void clearField(View view) {
        EditText ipField = (EditText) view;
        ipField.setText("");
    }

    public void connect(View view){
        EditText ipField = (EditText) findViewById(R.id.ip_address);
        EditText portField = (EditText) findViewById(R.id.port);

        RadioButton directRB = (RadioButton) findViewById(R.id.directRB);
        RadioButton remoteRB = (RadioButton) findViewById(R.id.remoteRB);

        String ip = String.valueOf(ipField.getText());
        Integer port = Integer.parseInt(portField.getText().toString());

        boolean dirRBStatus = directRB.isChecked();
        boolean remRBStatus = remoteRB.isChecked();

        Intent intent = new Intent(this, Driver.class);
        intent.putExtra("Direct radio button status", dirRBStatus);
        intent.putExtra("Remote radio button status", remRBStatus);
        intent.putExtra("IP", ip);
        intent.putExtra("Port", port);

        startActivity(intent);
    }

    public void pushDown(View view){

    }

    public void pushUp(View view){

    }
}
