package com.nftapp.nftmarketplace;

import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nftapp.nftmarketplace.adapter.QuizzPackageAdapter;
import com.nftapp.nftmarketplace.model.QuizzPackage;

import java.util.ArrayList;
import java.util.List;

public class QuizzPackageSelector extends AppCompatActivity {

    private ImageView back_button;
    private RecyclerView rcvItem;
    private QuizzPackageAdapter mQuizzPackageAdapter;

    private List<QuizzPackage> mQuizzPackagesList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizz_package_selector);
        back_button = findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final MediaPlayer mediaPlayer = MediaPlayer.create(QuizzPackageSelector.this,R.raw.close_effect);
                mediaPlayer.start();
                onBackPressed();
            }
        });
        rcvItem = findViewById(R.id.rcv_items);
        mQuizzPackageAdapter = new QuizzPackageAdapter(this);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Màn hình đang ở chế độ ngang
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
            rcvItem.setLayoutManager(gridLayoutManager);
        } else {
            // Màn hình đang ở chế độ dọc
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
            rcvItem.setLayoutManager(gridLayoutManager);
        }

        Bundle bundle = getIntent().getExtras();
        if(bundle == null) {
            return;
        }
        getListItem();
        rcvItem.setAdapter(mQuizzPackageAdapter);

    }
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Bundle bundle = getIntent().getExtras();
//        if(bundle == null) {
//            return;
//        }
//        Category category = (Category) bundle.get("object_category");
//        getListItem(category.getCategory_name());
//
//    }

    private void getListItem(){

//        ApiService.apiService.sendPOST_item(category,"","").enqueue(new Callback<List<Item>>() {
//
//            @Override
//            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
//                List<Item> list = response.body();
//                mQuizzPackageAdapter.setData(list);
//            }
//            @Override
//            public void onFailure(Call<List<Item>> call, Throwable t) {
//            }
//        });
        List<QuizzPackage> quizzPackageList = new ArrayList<>();
        quizzPackageList.add(new QuizzPackage(1,"1"));
        quizzPackageList.add(new QuizzPackage(1,"2"));
        quizzPackageList.add(new QuizzPackage(1,"3"));
        quizzPackageList.add(new QuizzPackage(1,"4"));
        quizzPackageList.add(new QuizzPackage(1,"5"));
        quizzPackageList.add(new QuizzPackage(1,"6"));
        quizzPackageList.add(new QuizzPackage(1,"7"));
        quizzPackageList.add(new QuizzPackage(1,"8"));
        quizzPackageList.add(new QuizzPackage(1,"9"));
        quizzPackageList.add(new QuizzPackage(1,"10"));
        quizzPackageList.add(new QuizzPackage(1,"11"));
        quizzPackageList.add(new QuizzPackage(1,"12"));
        quizzPackageList.add(new QuizzPackage(1,"13"));
        quizzPackageList.add(new QuizzPackage(1,"14"));
        quizzPackageList.add(new QuizzPackage(1,"15"));
        quizzPackageList.add(new QuizzPackage(1,"16"));
        quizzPackageList.add(new QuizzPackage(1,"17"));
        quizzPackageList.add(new QuizzPackage(1,"18"));
        quizzPackageList.add(new QuizzPackage(1,"19"));
        mQuizzPackageAdapter.setData(quizzPackageList);
    }


}
