package com.connortechs.androidchatapp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TCPConnection tcpConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppMain();
    }


    private void AppMain()
    {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    tcpConnection = new TCPConnection("irgendwas");
                    tcpConnection.Send("Hallo Raspberry!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    //e.printStackTrace();
                }
            }
        });

        thread.start();
        //tcpConnection = new TCPConnection("irgendwas");
        //tcpConnection.doInBackground();
    }

    public void SendToast(View view) {
        Toast.makeText(this, "FUCK YOU JAVA", Toast.LENGTH_LONG).show();
    }


}
