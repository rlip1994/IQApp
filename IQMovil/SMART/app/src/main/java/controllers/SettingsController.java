package controllers;

import android.content.Intent;
import android.widget.Switch;

import com.smartapp.web.smart.Activity_Child;
import com.smartapp.web.smart.Activity_Settings;
import com.smartapp.web.smart.LoginActivity;

import utils.PlayerSounds;
import utils.Settings;

/**
 * Created by kanat on 8/11/2017.
 */

public class SettingsController {

    private Activity_Settings activity;

    public SettingsController(Activity_Settings activity_settings) {
        this.activity = activity_settings;
    }

    public void setSoundValue(Switch soundValue){
        Settings.setActiveSounds();
        soundValue.setChecked(Settings.activeSounds);
        PlayerSounds.playSwitchClick(this.activity);
    }
    public void logOutSystem() {

        Intent activityI = new Intent(this.activity.getApplicationContext(),LoginActivity.class);
        //activityI.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activityI.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        UserController.user = null;
        this.activity.startActivity(activityI);
        this.activity.finish();
    }

    public void showKidSelectActivity() {
        PlayerSounds.playGoodClick(this.activity);
        Intent activityI = new Intent(this.activity.getApplicationContext(),Activity_Child.class);
        activityI.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.activity.startActivity(activityI);
    }
}
