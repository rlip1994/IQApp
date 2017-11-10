package controllers;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.smartapp.web.smart.Activity_Child;
import com.smartapp.web.smart.Activity_Main;
import com.smartapp.web.smart.Activity_Settings;
import com.smartapp.web.smart.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import model.Kid;
import model.User;
import conexion.AppController;
import utils.Const;
import utils.Message;

/**
 * Created by kanat on 19/9/2017.
 */

public class UserController {

    private Activity_Child activity;
    private String tag_json_arry = "jarray_req";
    public static User user; // Use static to access in all activity
    private String TAG = "UserController";


    public UserController(Activity_Child pActivity) {
        this.activity = pActivity;
        this.getKidsxUser();
    }
    private void getKidsxUser() {
        this.activity.showProgressBar();
        Message.showAlertMessage(activity,user.toString());
        String idUser =  String.valueOf(user.getIdUser());
        JsonArrayRequest req = new JsonArrayRequest(Const.URL_USERS+idUser,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        try {
                            getArrayKids(response.toString());
                            createKidsListView();
                            setListViewActivity();
                        } catch (JSONException e) {
                            Message.showAlertMessage(activity,"Error al convertir string en JSON");
                        }
                        hideProgressDialog();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Message.showAlertMessage(activity,"Error en conexion" + error.toString());
                hideProgressDialog();
            }

        });
        // Adding request to request queue
        if (req == null){
            Toast.makeText(MainActivity.activity,req.toString(),Toast.LENGTH_LONG).show();
        }
        AppController.getInstance().addToRequestQueue(req, tag_json_arry);


    }

    private void hideProgressDialog() {
        this.activity.hiddenProgressBar();
    }

    private void setListViewActivity() {
        this.activity.addListAdapter();
        this.activity.setListClickListener();
    }


    private void createKidsListView() {
        ArrayList<Kid> kids = this.user.getKidsUser();
        this.activity.clearDataView();
        for (Kid kid : kids) {
            String idKid = String.valueOf(kid.getIdKid());
            String idGrade = String.valueOf(kid.getGradeIdKid());
            this.activity.addDataListView(idKid,kid.getNameKid(),idGrade,kid.getSchoolKid());
        }
    }
    /**
     *"idplayer": 1,
     "playername": "Fulano apellido1",
     "idGrade": 2,
     "schoolname": "Escuela 1 "**/

    private void getArrayKids(String pString) throws JSONException {
        this.user.clearKidsArray();
        JSONArray arrayJson = new JSONArray(pString);
        arrayJson = arrayJson.getJSONArray(0);
        //Declare temporal variables
        int idPlayer;
        String namePlayer = "";
        int idGrade = 0;
        String schoolName = "";
        Kid tempKid;


        for (int i = 0; i < arrayJson.length(); i++) {
            JSONObject jsonObj = arrayJson.getJSONObject(i);
            idPlayer = jsonObj.getInt("idplayer");
            namePlayer = jsonObj.getString("playername");
            idGrade = jsonObj.getInt("idGrade");
            schoolName = jsonObj.getString("schoolname");
            tempKid = new Kid(idPlayer,namePlayer,idGrade,schoolName);
            this.user.addKidUser(tempKid);
        }
    }

    public void setCurrentKid(Integer pIdUser) {
        this.user.setCurrentKid(pIdUser);
    }


    public void showMainActivity() {
        if(Activity_Settings.activity_settingsInstance!=null){
            Activity_Settings.activity_settingsInstance.finish();
        }
        Intent Activity = new Intent(this.activity.getApplicationContext(), Activity_Main.class);
        this.activity.startActivity(Activity);
        this.activity.finish();
    }
}
