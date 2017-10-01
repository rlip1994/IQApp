package com.smartapp.web.smart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import Model.User;

/**
 * Created by klcho.o on 16/9/2017.
 */

public class Activity_Main extends AppCompatActivity {

    private Button buttonStart;
    public static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.user = new User("Usuario 2", 2); // TEST USER TODO
        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activity = new Intent(getApplicationContext(),childList.class);
                activity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(activity);
            }
        });

    }
    public  void showAlertMessage(String pMessage){
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(pMessage);
        alertDialog.show();
    }
}
