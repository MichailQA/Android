package com.example.user.newapplication;

import android.util.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by User on 06.05.2017.
 */

public class ServerConnection implements Runnable{

    Socket client;
    PrintWriter printWriter;
    Thread thread;

    String ip;
    Integer port;
    boolean dirRBStatus;
    boolean remRBStatus;

    public void run(){
        Thread thread = new Thread(this);
        thread.start();
        try {
            client = new Socket(ip.toString(), port);
            printWriter = new PrintWriter(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //   printWriter.write("Up");
        //   printWriter.flush();
        //   printWriter.close();
    }

    public void stream(String data){
        Log.d("TTT", "Input data is: "+ data);
    }

    public ServerConnection(String ip, Integer port, boolean dirRBStatus, boolean remRBStatus){
        this.ip = ip;
        this.port = port;
        this.dirRBStatus = dirRBStatus;
        this.remRBStatus = remRBStatus;
    }
}
