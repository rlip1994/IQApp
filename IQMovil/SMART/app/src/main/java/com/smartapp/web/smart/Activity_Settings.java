package com.smartapp.web.smart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import controllers.SettingsController;
import utils.Settings;

public class Activity_Settings extends AppCompatActivity {
    private Switch soundValue;
    private Button selectKid;
    private Button logOut;
    public static Activity_Settings activity_settingsInstance; //Singleton Class
    private SettingsController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        activity_settingsInstance = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        this.controller =  new SettingsController(this);
        //Select kid from database
        initializeSelectKidButton();
        //System log out
        initializeLogOutButton();
        // Switch configuration
        initializeSoundSwitch();


    }
    private void initializeSelectKidButton(){
        selectKid = (Button) findViewById(R.id.selectKid_Button);
        this.selectKid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.showKidSelectActivity();
            }
        });
    }
    private void initializeSoundSwitch(){
        soundValue = (Switch) findViewById(R.id.sound_Switch);
        this.soundValue.setChecked(Settings.activeSounds);
        this.soundValue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                controller.setSoundValue(soundValue);
            }
        });
    }
    private void initializeLogOutButton(){
        logOut = (Button) findViewById(R.id.logOut_button);
        this.logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.logOutSystem();
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
           this.finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
