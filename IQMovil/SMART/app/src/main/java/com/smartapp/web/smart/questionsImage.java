package com.smartapp.web.smart;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import cn.iwgang.countdownview.CountdownView;

/**
 * Created by klcho.o on 15/9/2017.
 */

public class questionsImage extends AppCompatActivity {

    private CountdownView countDownTimer;
   

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_image);

        countDownTimer = (CountdownView) findViewById(R.id.time);
        countDownTimer.start(45000); // 45 segundos

    }


    public void onRadioButtonClicked(View view){

        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.option1:
                if (checked)
                    countDownTimer.stop();
                break;
            case R.id.option2:
                if (checked)
                    countDownTimer.stop();
                break;
            case R.id.option3:
                if (checked)
                    countDownTimer.stop();
                break;
            case R.id.option4:
                if (checked)
                    countDownTimer.stop();
                break;
        }

    }
}
