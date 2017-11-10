package utils;

import android.app.Activity;
import android.support.v7.app.AlertDialog;

/**
 * Created by kanat on 7/11/2017.
 */

public class Message {

    public static void showAlertMessage(Activity activity, String pMessage){
        AlertDialog alertDialog = new AlertDialog.Builder(activity).create();
        alertDialog.setTitle("Mensaje");
        alertDialog.setMessage(pMessage);
        alertDialog.show();
    }
}
