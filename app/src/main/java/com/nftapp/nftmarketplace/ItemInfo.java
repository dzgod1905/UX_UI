package com.nftapp.nftmarketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.nftapp.nftmarketplace.model.Item;

import java.util.List;
import java.util.Locale;

public class ItemInfo extends AppCompatActivity {
    private TextView item_content;

    private ImageView back_button;
    private ImageView item_image;
    private TextView item_name;
    private ImageButton speaker;
    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);
        speaker = findViewById(R.id.speaker);
        item_content = findViewById(R.id.item_content);
        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        Item item = (Item) bundle.get("object_item");
        item_image = findViewById(R.id.item_image);
        item_name = findViewById(R.id.item_name);

        item_image.setImageResource(item.getResourceImage());
        item_name.setText(item.getItem_name());
        item_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemInfo.this, ImgView.class);
                startActivity(intent);
            }
        });
        speaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ItemInfo.this,"hello",Toast.LENGTH_SHORT).show();
                textToSpeech = new TextToSpeech(ItemInfo.this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status == TextToSpeech.SUCCESS) {
                            textToSpeech.setLanguage(Locale.ENGLISH);
                            textToSpeech.setSpeechRate(1.0f);
                            textToSpeech.speak(item_content.getText().toString(),TextToSpeech.QUEUE_ADD,null);
                        }
                    }
                });
            }
        });

    }
}