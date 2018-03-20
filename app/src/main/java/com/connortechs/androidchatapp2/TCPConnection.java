package com.connortechs.androidchatapp2;

/**
 * Created by EricR on 20.03.2018.
 */

import java.io.*;
import java.net.*;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class TCPConnection extends AsyncTask<Void, Void, Void>{

    private static Socket clientSocket;
    private static BufferedReader inFromServer;
    private static DataOutputStream outToServer;
    String modifiedSentence;

    @Override
    protected Void doInBackground(Void... params){
            String sentence = "Hallo Server!";
            String modifiedSentence;
            Socket clientSocket;
            DataOutputStream outToServer;
            BufferedReader inFromServer;
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            try{
                clientSocket = new Socket(InetAddress.getByName("connortechs.goip.de"), 9000);
                outToServer = new DataOutputStream(clientSocket.getOutputStream());
                inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                sentence = inFromUser.readLine();
                outToServer.writeBytes(sentence + '\n');
                modifiedSentence = inFromServer.readLine();
                System.out.println("FROM SERVER: " + modifiedSentence);
                clientSocket.close();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println("Try-Catch überstanden");
        return null;
    }

    public TCPConnection(String test)
    {
    }

    public void Send(String sentence)
    {
        System.out.println("Versuche was zu senden...");
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        try{
            clientSocket = new Socket("79.232.223.223", 9000);
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            sentence = inFromUser.readLine();
            outToServer.writeBytes(sentence + '\n');
            modifiedSentence = inFromServer.readLine();
            System.out.println("FROM SERVER: " + modifiedSentence);
            clientSocket.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Try-Catch überstanden");
    }
}
