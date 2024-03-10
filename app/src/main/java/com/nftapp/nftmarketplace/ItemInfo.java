package com.nftapp.nftmarketplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.nftapp.nftmarketplace.model.Item;

import java.util.List;

public class ItemInfo extends AppCompatActivity {

    private ImageView back_button;
    private ImageView item_image;
    private TextView item_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);
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

        Intent intent = getIntent();
        item_image.setImageResource(item.getResourceImage());
        item_name.setText(item.getItem_name());


    }
}