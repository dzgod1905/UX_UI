package com.nftapp.nftmarketplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.nftapp.nftmarketplace.adapter.ItemAdapter;
import com.nftapp.nftmarketplace.model.Category;
public class CategoryPage extends AppCompatActivity {
    private TextView category_name;
    private ImageView back_button;
    private RecyclerView rcvItem;
    private ItemAdapter mItemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_page);
        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        rcvItem = findViewById(R.id.rcv_items);
        mItemAdapter = new ItemAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcvItem.setLayoutManager(gridLayoutManager);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null) {
            return;
        }
        Category category = (Category) bundle.get("object_category");
        category_name = findViewById(R.id.category_name);
        Intent intent = getIntent();
        category_name.setText(category.getNameCategory());
        mItemAdapter.setData(category.getItems());
        rcvItem.setAdapter(mItemAdapter);
    }


}


