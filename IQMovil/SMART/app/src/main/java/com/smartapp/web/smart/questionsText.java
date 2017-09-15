package com.smartapp.web.smart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import cn.iwgang.countdownview.CountdownView;

/**
 * Created by klcho.o on 12/9/2017.
 */

public class questionsText extends AppCompatActivity {

    private CountdownView countDownTimer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_text);

        countDownTimer = (CountdownView) findViewById(R.id.time);
        countDownTimer.start(45000); // 45 segundos
    }


    public void onRadioButtonClicked(View view){

        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.opcion1:
                if (checked)
                    countDownTimer.stop();
                    break;
            case R.id.opcion2:
                if (checked)
                    countDownTimer.stop();
                    break;
             case R.id.opcion3:
                if (checked)
                    countDownTimer.stop();
                    break;
            case R.id.opcion4:
                if (checked)
                    countDownTimer.stop();
                    break;
        }

    }

}
