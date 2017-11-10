package com.smartapp.web.smart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import controllers.MainController;

/**
 * Created by klcho.o on 16/9/2017.
 */

public class Activity_Main extends AppCompatActivity {

    //public Activity_Main activityInstance;

    private Button buttonStart;
    private ImageView setButton;
    private MainController controller;
    private TextView kidNameLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //activityInstance = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Components
        this.kidNameLabel = (TextView) findViewById(R.id.kidNameLabel);
        this.controller =  new MainController(this);
        //BUTTONS
        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){controller.verifyUserCurrent();
            }
        });
        setButton = (ImageView) findViewById(R.id.settingButton);
        setButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                controller.showSettingsActivity();
            }
        });

    }/**
     @Method setKidNameText
     @param pName : set Current kid name
     **/
    public void setKidNameText(String pName){
        this.kidNameLabel.setText(pName);
    }
}
