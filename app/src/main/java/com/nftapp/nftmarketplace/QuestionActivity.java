package com.nftapp.nftmarketplace;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Arrays;
import java.util.Locale;

public class QuestionActivity extends AppCompatActivity {
    private TextView countdown_timer;
    private ImageView close_button;
    private ConstraintLayout exit_quizz_layout;
    private CountDownTimer timer;
    private CardView option1_layout, option2_layout, option3_layout, option4_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_activity);
        Bundle bundle = getIntent().getExtras();
        String quizz_package = bundle.getString("quizz_package");
        option1_layout = findViewById(R.id.option1_layout);
        option2_layout = findViewById(R.id.option2_layout);
        option3_layout = findViewById(R.id.option3_layout);
        option4_layout = findViewById(R.id.option4_layout);
        countdown_timer = findViewById(R.id.countdown_timer);
        CardView[] option_layout = {option1_layout, option2_layout, option3_layout, option4_layout};
        for (CardView option: option_layout
             ) {
            option.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(QuestionActivity.this,quizz_package +" "+ String.valueOf(option.getId()),Toast.LENGTH_SHORT).show();
                }
            });
            
        }
        timer = new CountDownTimer(15000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long seconds = (millisUntilFinished / 1000) % 60;
                String timeFormatted = String.format(Locale.getDefault(),"%01d",seconds);
                countdown_timer.setText(timeFormatted);
                if(seconds <= 5) {
                    final MediaPlayer mediaPlayer = MediaPlayer.create(QuestionActivity.this,R.raw.timer);
                    mediaPlayer.start();
                }
            }
            @Override
            public void onFinish() {
                Toast.makeText(QuestionActivity.this,"Time up",Toast.LENGTH_SHORT).show();
            }
        }.start();
        close_button = findViewById(R.id.close_button);
        close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                final MediaPlayer mediaPlayer = MediaPlayer.create(QuestionActivity.this,R.raw.close_effect);
                mediaPlayer.start();
                timer.cancel();
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        View view = LayoutInflater.from(QuestionActivity.this).inflate(R.layout.exit_quizz, exit_quizz_layout);

        AlertDialog.Builder builder = new AlertDialog.Builder(QuestionActivity.this);
        builder.setView(view);
        Button cancel_button = view.findViewById(R.id.cancel_button);
        Button accept = view.findViewById(R.id.accept_button);
        final AlertDialog alertDialog = builder.create();
        if(alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                finish();
            }
        });
    }
}