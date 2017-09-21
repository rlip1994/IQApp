package Controllers;

import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.smartapp.web.smart.Activity_Main;
import com.smartapp.web.smart.MainActivity;
import com.smartapp.web.smart.childList;
import com.smartapp.web.smart.questionsText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import Model.Category;
import Model.Game;
import Model.Kid;
import Model.Question;
import Model.User;
import conexion.AppController;
import utils.Const;

/**
 * Created by kanat on 20/9/2017.
 */

public class QuestionController {
    private questionsText activity;
    private String tag_json_arry = "jarray_req";
    private Kid kid;
    private String TAG = "QuestionController";
    private Game game;
    private Question currentQuestion;


    public QuestionController(questionsText pActivity) {
        this.activity = pActivity;
        this.kid = Activity_Main.user.getCurrentKid();
        this.game = new Game(CategoryController.currentCategory);
        getQuestionxCategory();
    }
    private void getQuestionxCategory() {
        this.activity.showProgressBar();
        String data =  String.valueOf(game.getCategorySelected().getIdCategory())+"/"+String.valueOf(kid.getGradeIdKid()) ;
        JsonArrayRequest req = new JsonArrayRequest(Const.URL_QUESTIONS+data,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        try {
                            getArrayQuestions(response.toString());
                            showQuestion();
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

    private void showQuestion() {
        try {
            this.currentQuestion = this.game.getQuestion();
            String[] responses = this.currentQuestion.getAlternativeResponse();
            this.activity.showQuestion(currentQuestion.getTextQuestion(),responses[0],responses[1],responses[2],responses[3]);
        } catch (Exception e) {
            if(e.getMessage()=="Sin preguntas"){
                this.activity.finishGame();
            }else{
                showAlertMessage(e.getMessage());
            }
        }

    }

    private void hideProgressDialog() {
        this.activity.hiddenProgressBar();
    }


    /**
     *"idquestion": 15,
     "description": "pregunta9",
     "idgrade": 3,
     "idanswer": 3,
     "value": "anws1""**/

    private void getArrayQuestions(String pString) throws JSONException {
        JSONArray arrayJson = new JSONArray(pString);
        arrayJson = arrayJson.getJSONArray(0);
        //Declare temporal variables
        int idQuestion;
        String description = "";
        int idGrade;
        int idanswer;
        String valueAnswer = "";
        Question tempQuestion;
        for (int i = 0; i < arrayJson.length(); i++) {
            JSONObject jsonObj = arrayJson.getJSONObject(i);
            idQuestion = jsonObj.getInt("idquestion");
            description = jsonObj.getString("description");
            idGrade = jsonObj.getInt("idgrade");
            idanswer = jsonObj.getInt("idanswer");
            valueAnswer = jsonObj.getString("value");
            tempQuestion =  new Question(idQuestion,description,idanswer,valueAnswer);
            this.game.addQuestion(tempQuestion);
        }
    }
    public  void showAlertMessage(String pMessage){
        AlertDialog alertDialog = new AlertDialog.Builder(this.activity).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage(pMessage);
        alertDialog.show();
    }

}
