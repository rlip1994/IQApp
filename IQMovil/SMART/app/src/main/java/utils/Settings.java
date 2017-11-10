package utils;

/**
 * Created by kanat on 8/11/2017.
 */

public class Settings {
    public static Boolean activeSounds = false;

    public static void setActiveSounds(){
        if(activeSounds){
            activeSounds = false;
        }else{
            activeSounds = true;
        }
    }
}
