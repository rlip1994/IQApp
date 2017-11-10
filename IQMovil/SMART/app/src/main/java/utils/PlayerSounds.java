package utils;

import android.app.Activity;
import android.media.MediaPlayer;

import com.smartapp.web.smart.R;

/**
 * User this util for play dirent s
 */

public class PlayerSounds {
    public static void playWrongClick(Activity activity){
        MediaPlayer clickSound =  MediaPlayer.create(activity,R.raw.wrong);
        clickSound.start();
    }
    public static void playGoodClick(Activity activity){
        MediaPlayer clickSound =  MediaPlayer.create(activity, R.raw.assertclick);
        clickSound.start();
    }
    public static void playSwitchClick(Activity activity){
        MediaPlayer clickSound =  MediaPlayer.create(activity, R.raw.switchclick);
        clickSound.start();
    }
    public static void playAnswerClick(Activity activity){
        MediaPlayer clickSound =  MediaPlayer.create(activity, R.raw.answerclick);
        clickSound.start();
    }
}
