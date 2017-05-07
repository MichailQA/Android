package com.example.user.newapplication;

import android.util.Log;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerConnection implements Runnable{

    Socket client;
    PrintWriter printWriter;
    Thread thread;

    String ip;
    Integer port;
    public String data = "empty";
    boolean dirRBStatus;
    boolean remRBStatus;

    private boolean runner = true;

    public ServerConnection(String ip, Integer port, boolean dirRBStatus, boolean remRBStatus){
        this.ip = ip;
        this.port = port;
        this.dirRBStatus = dirRBStatus;
        this.remRBStatus = remRBStatus;
    }

    public void stop(){
        runner = false;
    }

    public void run(){
        try {
            client = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(runner){
            if(!data.equals("empty")) {
                try {
                    printWriter = new PrintWriter(client.getOutputStream());
                    printWriter.write(data+"\n");
                    printWriter.flush();
                    Thread.sleep(100);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        printWriter.close();
    }
}
