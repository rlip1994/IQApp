package com.smartapp.web.smart;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

import cn.iwgang.countdownview.CountdownView;

/**
 * Created by klcho.o on 12/9/2017.
 */

public class preguntas extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preguntas);

        CountdownView countDownTimer = (CountdownView) findViewById(R.id.tiempo);
        countDownTimer.start(45000); // 45 segundos
    }
}
