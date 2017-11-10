package controllers;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.smartapp.web.smart.MainActivity;
import com.smartapp.web.smart.questionsText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import conexion.AppController;
import exceptions.EmptyQuestionArrayException;
import exceptions.MessageException;
import model.Game;
import model.Kid;
import model.Question;
import utils.Const;
import utils.Message;

/**
 * Created by kanat on 20/9/2017.
 */

public class QuestionController {
    private questionsText activity;
    private String tag_json_arry = "jarray_req";
    private Kid kid;
    private String TAG = "QuestionController";
    private Game game;


    public QuestionController(questionsText pActivity) {
        this.activity = pActivity;
        this.kid = UserController.user.getCurrentKid();
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
                            selectCurrentQuestion();
                        } catch (JSONException e) {
                            Message.showAlertMessage(activity,"!No podemos mostrar las preguntas en estos momentos");
                        }
                        hideProgressDialog();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Message.showAlertMessage(activity,"¡Ops!,No podemos acceder al servidor");

                hideProgressDialog();
            }

        });
        // Adding request to request queue
        if (req == null){
            Toast.makeText(MainActivity.activity,req.toString(),Toast.LENGTH_LONG).show();
        }
        AppController.getInstance().addToRequestQueue(req, tag_json_arry);


    }
    private void selectCurrentQuestion(){
        try {
            this.game.setCurrentQuestion();
            this.getAlternativeResponse();
        } catch (EmptyQuestionArrayException e) {
            if(e.getMessage()==MessageException.NOFOUNDQUESTIONS)
                Message.showAlertMessage(this.activity,MessageException.NOFOUNDQUESTIONS);
            else
                Message.showAlertMessage(this.activity,MessageException.UNKNOWEXCEPTION+e.getMessage());
        }

    }

    private void showQuestion() {
            Message.showAlertMessage(this.activity, Arrays.toString(this.game.getCurrentQuestion().getAlternativeResponse()));
            String[] responses = this.game.getCurrentQuestion().getAlternativeResponse();
            if (responses == null){
                Message.showAlertMessage(this.activity,MessageException.NOFOUNDANSWERS);
            }else{
                this.activity.showQuestion(this.game.getCurrentQuestion().getTextQuestion(),responses);
            }

    }


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


    public void answerCurrentQuestion(String text, int time) {
        Message.showAlertMessage(this.activity,"Response is"+ text +"and time is"+String.valueOf(time));
    }

    public void getAlternativeResponse(){
       // questions/answers/2
        String data =  String.valueOf(this.game.getCurrentQuestion().getIdQuestion()) ;
        JsonArrayRequest req = new JsonArrayRequest(Const.URL_ANSWERS_QUESTIONS+data,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());
                        try {
                            String[] responses = getArrayResponse(response.toString());
                            addQuestionResponses(responses);
                            showQuestion();
                        } catch (JSONException e) {
                            Message.showAlertMessage(activity,"!No podemos mostrar las preguntas en estos momentos");
                        }
                        hideProgressDialog();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Message.showAlertMessage(activity,"¡Ops!,No podemos acceder al servidor");
                hideProgressDialog();
            }

        });
        // Adding request to request queue
        if (req == null){
            Toast.makeText(this.activity,req.toString(),Toast.LENGTH_LONG).show();
        }
        AppController.getInstance().addToRequestQueue(req, tag_json_arry);

    }

    private void addQuestionResponses(String[] responses) {
        this.game.AddAlternativeResponses(responses);
    }

    private String[] getArrayResponse(String s) throws JSONException {
        JSONArray arrayJson = new JSONArray(s);
        arrayJson = arrayJson.getJSONArray(0);
        //Declare temporal variables
        String value;
        String[] responses = new String[3];
        for (int i = 0; i < arrayJson.length() || i==2; i++) {
            JSONObject jsonObj = arrayJson.getJSONObject(i);
            responses[i] = jsonObj.getString("value");
        }
        return responses;
    }
    private void hideProgressDialog() {
        this.activity.hiddenProgressBar();
    }
}
