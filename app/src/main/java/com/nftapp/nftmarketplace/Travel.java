package com.nftapp.nftmarketplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.nftapp.nftmarketplace.adapter.CategoryAdapter;
import com.nftapp.nftmarketplace.model.Category;
import com.nftapp.nftmarketplace.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Travel extends AppCompatActivity {
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_page);
        rcvCategory = findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);
        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);

//        Bundle bundleReceive = getIntent().getExtras();
//        User user = (User) bundleReceive.get("object_user");
    }

    private List<Category> getListCategory(){
        List<Category> listCategory = new ArrayList<>();
        List<Item> list1 = new ArrayList<>();
        List<Item> list2 = new ArrayList<>();
        List<Item> list3 = new ArrayList<>();
        list1.add(new Item(1,R.drawable.avt1, "Avt1"));
        list1.add(new Item(2,R.drawable.avt2, "Avt2"));
        list1.add(new Item(3,R.drawable.avt3, "Avt3"));
        list1.add(new Item(4,R.drawable.avt4, "Avt4"));
        list1.add(new Item(5,R.drawable.avt5, "Avt5"));
        list2.add(new Item(6,R.drawable.avt6, "Avt6"));
        list2.add(new Item(7,R.drawable.avt7, "Avt7"));
        list2.add(new Item(8,R.drawable.avt8, "Avt8"));
        list2.add(new Item(9,R.drawable.avt9, "Avt9"));
        list2.add(new Item(10,R.drawable.avt1, "Avt1"));
        list2.add(new Item(11,R.drawable.avt2, "Avt2"));
        list3.add(new Item(12,R.drawable.avt3, "Avt3"));
        list3.add(new Item(13,R.drawable.avt4, "Avt4"));
        list3.add(new Item(14,R.drawable.avt5, "Avt5"));
        list3.add(new Item(15,R.drawable.avt6, "Avt6"));
        list3.add(new Item(16,R.drawable.avt7, "Avt7"));
        list3.add(new Item(17,R.drawable.avt8, "Avt8"));
        list3.add(new Item(18,R.drawable.avt9, "Avt9"));
        listCategory.add(new Category("Xu hướng",list1));
        listCategory.add(new Category("Địa danh nổi tiếng",list2));
        listCategory.add(new Category("Di sản văn hóa",list3));
        return listCategory;
    }


}