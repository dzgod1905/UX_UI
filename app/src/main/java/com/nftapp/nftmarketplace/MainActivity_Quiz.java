package com.nftapp.nftmarketplace;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;


public class MainActivity_Quiz extends AppCompatActivity {

    private int presCounter = 0;
    private int[] generalPressCounter = {4,3,4};
    private String[] genralTextAnswer = {"BIRD","CAT","LION"};
    private String[][] generalKey = {{"R", "I", "B", "D"},{"C", "A", "T", "D"},{"L", "I", "O", "N"}};



    TextView textQuestion, textTitle;
    Animation smallbigforth;

    public int value =  0;
    public String[] keys = generalKey[value];
    public String textAnswer = genralTextAnswer[value];
    public int maxPresCounter = generalPressCounter[value];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        value = intent.getIntExtra("i",0);
        keys = generalKey[value];
        textAnswer = genralTextAnswer[value];
        maxPresCounter = generalPressCounter[value];
        smallbigforth = AnimationUtils.loadAnimation(this, R.anim.smallbigforth);

        keys = shuffleArray(keys);

        for (String key : keys) {
            addView(((LinearLayout) findViewById(R.id.layoutParent)), key, ((EditText) findViewById(R.id.editText)));
        }
        CountDownTimer cdt = new CountDownTimer(15 * 1000 + 500, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int)millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                TextView textViewCountDown = findViewById(R.id.time);
                textViewCountDown.setText("Time Out");
                EditText editText = findViewById(R.id.editText);
                editText.setText(textAnswer);
            }
        }.start();

    }

    private void updateTimer(int i) {
        TextView textViewCountDown = findViewById(R.id.time);
        textViewCountDown.setText(String.valueOf(i));
    }


    private String[] shuffleArray(String[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }


    private void addView(LinearLayout viewParent, final String text, final EditText editText) {
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        linearLayoutParams.rightMargin = 30;

        final TextView textView = new TextView(this);

        textView.setLayoutParams(linearLayoutParams);
        textView.setBackground(this.getResources().getDrawable(R.drawable.bgpink));
        textView.setTextColor(this.getResources().getColor(R.color.colorPurple));
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setTextSize(16);


        textQuestion = (TextView) findViewById(R.id.textQuestion);
        textTitle = (TextView) findViewById(R.id.textTitle);


        textView.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(presCounter < maxPresCounter) {
                    if (presCounter == 0)
                        editText.setText("");

                    editText.setText(editText.getText().toString() + text);
                    textView.startAnimation(smallbigforth);
                    textView.animate().alpha(0).setDuration(300);
                    presCounter++;

                    if (presCounter == maxPresCounter)
                        doValidate();
                }
            }
        });


        viewParent.addView(textView);


    }


    private void doValidate() {
        presCounter = 0;


        EditText editText = findViewById(R.id.editText);
        LinearLayout linearLayout = findViewById(R.id.layoutParent);

        if(editText.getText().toString().equals(textAnswer)) {
            Toast.makeText(MainActivity_Quiz.this, "Correct", Toast.LENGTH_SHORT).show();
            Intent a = new Intent(MainActivity_Quiz.this, BossAct.class);
            a.putExtra("l", value+1);
            if (value == 2) {
                Intent end = new Intent(MainActivity_Quiz.this, DoneAllQuiz.class);
                startActivity(end);
            } else {
                startActivity(a);
            }

            editText.setText("");
        } else {
            Toast.makeText(MainActivity_Quiz.this, "Wrong", Toast.LENGTH_SHORT).show();
            editText.setText("");
        }

        keys = shuffleArray(keys);
        linearLayout.removeAllViews();
        for (String key : keys) {
            addView(linearLayout, key, editText);
        }

    }


}
