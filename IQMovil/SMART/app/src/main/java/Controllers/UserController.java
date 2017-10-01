package Controllers;

import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.smartapp.web.smart.Activity_Main;
import com.smartapp.web.smart.MainActivity;
import com.smartapp.web.smart.childList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Model.Category;
import Model.Kid;
import Model.User;
import conexion.AppController;
import utils.Const;

/**
 * Created by kanat on 19/9/2017.
 */

public class UserController {

    private childList activity;
    private String tag_json_arry = "jarray_req";
    private User user;
    private String TAG = "UserController";


    public UserController(childList pActivity) {
        this.activity = pActivity;
        this.user = Activity_Main.user;
        getKidsxUser();
    }


    private void getKidsxUser() {
        this.activity.showProgressBar();
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
                            showAlertMessage("Error al convertir string en JSON");
                        }
                        hideProgressDialog();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                showAlertMessage("Error en conexion" + error.toString());
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
    public  void showAlertMessage(String pMessage){
        AlertDialog alertDialog = new AlertDialog.Builder(this.activity).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(pMessage);
        alertDialog.show();
    }

    public void setCurrentKid(Integer pIdUser) {
        this.user.setCurrentKid(pIdUser);
    }
}
