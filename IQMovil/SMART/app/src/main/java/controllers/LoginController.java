package controllers;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.smartapp.web.smart.Activity_Main;
import com.smartapp.web.smart.LoginActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import model.User;
import conexion.AppController;
import exceptions.loginException;
import utils.Const;
import utils.Message;

/**
 * Created by kanat on 6/11/2017.
 */

public class LoginController {
    private LoginActivity activity;
    private String tag_json_arry = "jarray_req";
    private String TAG = "UserController";
    private User user;
    public LoginController(LoginActivity lActivity){
        this.activity = lActivity;

    }

    public void validateUser(String userName,String password){
        //showAlertMessage(Const.URL_VALIDATION+userName+"/"+password);
        Toast.makeText( this.activity,Const.URL_VALIDATION+userName+"/"+password,Toast.LENGTH_LONG).show();
        JsonArrayRequest req = new JsonArrayRequest(Const.URL_VALIDATION+userName+"/"+password,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        try {
                            getUserId(response.toString());
                            showMainActivity();
                        } catch (JSONException e) {
                            showAlertMessage("Error al convertir string en JSON");
                        }catch (loginException le){
                            showLoginFailed();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Message.showAlertMessage(getCurrentActivity(),error.getMessage());

                //hideProgressDialog();
            }
        });

        // Adding request to request queue
        if (req == null){
            Toast.makeText(this.activity,req.toString(),Toast.LENGTH_LONG).show();
        }
        AppController.getInstance().addToRequestQueue(req,
                tag_json_arry);

    }

    private void showLoginFailed() {
        this.activity.showLoginError();
    }
    private Activity getCurrentActivity(){return this.activity;}

    private void showMainActivity() {
        Intent activityI = new Intent(this.activity.getApplicationContext(),Activity_Main.class);
        activityI.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        UserController.user = this.user; // Save user instance
        this.activity.startActivity(activityI);
        this.activity.finish();
    }

    private void getUserId(String s) throws JSONException, loginException {
        JSONArray arrayJson = new JSONArray(s);
        arrayJson = arrayJson.getJSONArray(0);
        if (arrayJson.length()==0) {
            throw new loginException("Usuario o Contraseña incorrectos");
        }else {
            int idUser = 0;
            for (int i = 0; i < arrayJson.length(); i++) {
                JSONObject jsonObj = arrayJson.getJSONObject(i);
                idUser = jsonObj.getInt("iduser");
            }
            user = new User(idUser);
        }

    }
    public  void showAlertMessage(String pMessage){
        AlertDialog alertDialog = new AlertDialog.Builder(this.activity).create();
        alertDialog.setTitle("Mensaje");
        alertDialog.setMessage(pMessage);
        alertDialog.show();
    }
}
