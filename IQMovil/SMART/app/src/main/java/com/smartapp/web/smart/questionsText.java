package com.smartapp.web.smart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import cn.iwgang.countdownview.CountdownView;
import controllers.QuestionController;
import utils.PlayerSounds;

/**
 * Created by klcho.o on 12/9/2017.
 */

public class questionsText extends AppCompatActivity {

    private CountdownView countDownTimer;
    private ProgressBar progressBar;
    private Button response;
    private TextView statement;
    private RadioButton opcion1;
    private RadioButton opcion2;
    private RadioButton opcion3;
    private RadioButton opcion4;

    private String selectedAnswer;
    private Integer timeValue = 45000; // 45 seconds
    private QuestionController controller;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_text);
        // Instance all view objects
        this.progressBar = (ProgressBar)  findViewById(R.id.progressbar);

        countDownTimer = (CountdownView) findViewById(R.id.time);

        this.statement = (TextView) findViewById(R.id.statement);
        this.opcion1 = (RadioButton)  findViewById(R.id.opcion1);
        this.opcion2 = (RadioButton)  findViewById(R.id.opcion2);
        this.opcion3 = (RadioButton)  findViewById(R.id.opcion3);
        this.opcion4 = (RadioButton)  findViewById(R.id.opcion4);

        this.response = (Button)  findViewById(R.id.answerButton);
        this.response.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendResponse();
            }
        });

        this.hiddenProgressBar();
        // Call Question controller
        this.controller =  new QuestionController(this);

    }
    public void setQuestionController(QuestionController pController){
        this.controller = pController;
    }



    public void startTimer(){
        countDownTimer.start(timeValue);
    }

    public int stopTimer(){
        countDownTimer.stop();
        return this.countDownTimer.getSecond();
    }


    public void onRadioButtonClicked(View view){
        PlayerSounds.playAnswerClick(this);
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.opcion1:
                if (checked)
                    this.setSelectedAnswer(R.id.opcion1);
                    break;
            case R.id.opcion2:
                if (checked)
                    this.setSelectedAnswer(R.id.opcion2);
                    break;
             case R.id.opcion3:
                if (checked)
                    this.setSelectedAnswer(R.id.opcion3);
                    break;
            case R.id.opcion4:
                if (checked)
                    this.setSelectedAnswer(R.id.opcion4);
                    break;
        }

    }
    private void setSelectedAnswer(int option){
        PlayerSounds.playAnswerClick(this);
        this.selectedAnswer = (String) ((RadioButton)  findViewById(option)).getText();

    }

    private void sendResponse() {
        PlayerSounds.playGoodClick(this);
        int time = this.stopTimer();
        controller.answerCurrentQuestion(this.selectedAnswer,time,this.getTimeValue());
    }

    public void  showProgressBar(){
        this.progressBar.setVisibility(View.VISIBLE);
    }
    public void  hiddenProgressBar(){
        this.progressBar.setVisibility(View.INVISIBLE);
    }

    public void finishGame() {
        //TODO
    }

    public void showQuestion(String textQuestion, String[] responses) {
       // Message.showAlertMessage(this, Arrays.toString(responses));
        //Clean options
        this.statement.setText(textQuestion);
        this.opcion1.setText(responses[0]);
        this.opcion2.setText(responses[1]);
        this.opcion3.setText(responses[2]);
        this.opcion4.setText(responses[3]);
        this.startTimer();
    }

    //SETTERS AND GETTERS
    public Integer getTimeValue() {
        return timeValue;
    }
}
