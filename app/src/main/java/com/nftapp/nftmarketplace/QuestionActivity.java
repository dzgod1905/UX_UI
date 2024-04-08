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

import com.nftapp.nftmarketplace.model.Question;

import java.util.Arrays;
import java.util.Locale;

public class QuestionActivity extends AppCompatActivity {
    private TextView countdown_timer;
    private TextView question_text;
    private String key;
    private ImageView close_button;
    private ConstraintLayout exit_quizz_layout;
    private CountDownTimer timer;
    private CardView option1_layout, option2_layout, option3_layout, option4_layout;
    private TextView option1, option2, option3, option4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_activity);
        Bundle bundle = getIntent().getExtras();
        String quizz_package = bundle.getString("quizz_package");
        question_text = findViewById(R.id.question_text);
        option1_layout = findViewById(R.id.option1_layout);
        option2_layout = findViewById(R.id.option2_layout);
        option3_layout = findViewById(R.id.option3_layout);
        option4_layout = findViewById(R.id.option4_layout);
        countdown_timer = findViewById(R.id.countdown_timer);
        CardView[] option_layout = {option1_layout, option2_layout, option3_layout, option4_layout};
        option1 = findViewById(R.id.option_1);
        option2 = findViewById(R.id.option_2);
        option3 = findViewById(R.id.option_3);
        option4 = findViewById(R.id.option_4);
        TextView[] option_answer = {option1, option2, option3, option4};
        getQuestion();
        for (int i = 0;i<4;i++) {
            int finalI = i;
            option_layout[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(option_answer[finalI].getText().equals(key)) {
                        Toast.makeText(QuestionActivity.this, "correct", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(QuestionActivity.this, "failed", Toast.LENGTH_SHORT).show();
                    }
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
    public void getQuestion() {
        Question question = new Question("","Cầu Vàng được xây dựng ở mô","Thanh Hóa","Đà Nẵng","Hà Nội","Ninh Bình","Đà Nẵng");
        question_text.setText(question.getQuestion_text());
        option1.setText(question.getQuestion_option1());
        option2.setText(question.getQuestion_option2());
        option3.setText(question.getQuestion_option3());
        option4.setText(question.getQuestion_option4());
        key = question.getQuestion_key();

    }
}