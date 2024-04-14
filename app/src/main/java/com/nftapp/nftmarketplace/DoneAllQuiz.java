package com.nftapp.nftmarketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DoneAllQuiz extends AppCompatActivity {

    TextView textQuestion, textTitle ;
    ImageView bigboss;
    Animation smalltobig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done_all_quiz);
        smalltobig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);

        textQuestion = (TextView) findViewById(R.id.textQuestion);
        textTitle = (Button) findViewById(R.id.textTitle);

        bigboss = (ImageView) findViewById(R.id.bigboss);
        bigboss.startAnimation(smalltobig);
    }
}