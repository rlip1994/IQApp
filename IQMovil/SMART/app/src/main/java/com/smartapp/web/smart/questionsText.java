package com.smartapp.web.smart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import Controllers.QuestionController;
import Model.Question;
import cn.iwgang.countdownview.CountdownView;

/**
 * Created by klcho.o on 12/9/2017.
 */

public class questionsText extends AppCompatActivity {

    private CountdownView countDownTimer;
    private ProgressBar progressBar;
    private TextView statement;
    private RadioButton opcion1;
    private RadioButton opcion2;
    private RadioButton opcion3;
    private RadioButton opcion4;

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

        this.hiddenProgressBar();
        // Call Question controller
        this.controller =  new QuestionController(this);

    }
    public void setQuestionController(QuestionController pController){
        this.controller = pController;
    }



    public void startTimer(){
        countDownTimer.start(45000); // 45 segundos
    }

    public int stopTimer(){
        countDownTimer.stop();
        return this.countDownTimer.getSecond();
    }

    public void showQuestion(String... params){
        this.statement.setText(params[0]);
        this.opcion1.setText(params[1]);
        this.opcion2.setText(params[2]);
        this.opcion3.setText(params[3]);
        this.opcion4.setText(params[4]);
        this.startTimer();
    }


    public void onRadioButtonClicked(View view){

        boolean checked = ((RadioButton) view).isChecked();
        int time ;
        switch(view.getId()) {
            case R.id.opcion1:
                if (checked)
                    time = this.stopTimer();
                    break;
            case R.id.opcion2:
                if (checked)
                    time = this.stopTimer();
                    break;
             case R.id.opcion3:
                if (checked)
                    time = this.stopTimer();
                    break;
            case R.id.opcion4:
                if (checked)
                    time = this.stopTimer();
                    break;
        }

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
}
