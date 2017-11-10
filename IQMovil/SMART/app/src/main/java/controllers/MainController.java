package controllers;

import android.content.Intent;
import android.media.MediaPlayer;

import com.smartapp.web.smart.Activity_Main;
import com.smartapp.web.smart.Activity_Settings;
import com.smartapp.web.smart.categoryList;

import utils.Message;
import utils.PlayerSounds;

/**
 * Created by kanat on 7/11/2017.
 */

public class MainController {
    //PARAMETERS
    private Activity_Main activity;
    private MediaPlayer clickSound;

    public MainController(Activity_Main pActivity){
        this.activity = pActivity;
        initializeKidLabel();
    }
    //GAME VALIDATION
    public void verifyUserCurrent() {
        if (UserController.user.isSelectedKid()){
            PlayerSounds.playGoodClick(this.activity); //UTIL CLASS
            showSelectCategory();
        }else{
            PlayerSounds.playWrongClick(this.activity);//UTIL CLASS
            Message.showAlertMessage(this.activity,"Selecciona un jugador en configuraciones");
        }
    }
    // SHOW ACTIVITIES
    public void showSettingsActivity() {
        Intent activityI = new Intent(this.activity.getApplicationContext(),Activity_Settings.class);
        activityI.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.activity.startActivity(activityI);
    }
    public void showSelectCategory() {
        Intent activityI = new Intent(this.activity.getApplicationContext(),categoryList.class);
        activityI.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.activity.startActivity(activityI);
        this.activity.finish();
    }
    //LABEL CONTROLLER
    private void initializeKidLabel(){
        if(UserController.user.isSelectedKid()){
            this.activity.setKidNameText("Bienvenido:"+UserController.user.getCurrentKid().getNameKid());
        }else{
            this.activity.setKidNameText("¡Selecciona un jugador registrado!");
        }
    }
}
