package com.nftapp.nftmarketplace;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nftapp.nftmarketplace.adapter.ImageAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageAdapter adabter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coloring);

        initTollbar();

        initView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler_view_images);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adabter = new ImageAdapter(this);
        recyclerView.setAdapter(adabter);
    }

    private void initTollbar() {
        Toolbar toolbar = findViewById(R.id.tollbar);
        setSupportActionBar(toolbar);
        int toolbar_item_color = ResourcesCompat.getColor(getResources(), R.color.blue, null);
        toolbar.setTitleTextColor(toolbar_item_color);
        toolbar.setSubtitleTextColor(toolbar_item_color);
        getSupportActionBar().setTitle("My Pictures");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.close);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       int id = item.getItemId();

       if(id == android.R.id.home) {
           finish();
       }

       return super.onOptionsItemSelected(item);
    }

}
