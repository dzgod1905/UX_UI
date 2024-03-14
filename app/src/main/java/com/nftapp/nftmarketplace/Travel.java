package com.nftapp.nftmarketplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.nftapp.nftmarketplace.adapter.CategoryAdapter;
import com.nftapp.nftmarketplace.adapter.ItemAdapter;
import com.nftapp.nftmarketplace.adapter.ItemAdapter_2;
import com.nftapp.nftmarketplace.model.Category;
import com.nftapp.nftmarketplace.model.Item;

import java.util.ArrayList;
import java.util.List;


public class Travel extends AppCompatActivity {
    private ImageView back_button;
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
    private SearchView searchView;
    private ItemAdapter_2 mItemAdapter;
    private List<Item> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_page);
        back_button = findViewById(R.id.back_button);
//        itemAdapter = new ItemAdapter(this);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        rcvCategory = findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);
        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
        searchView = findViewById(R.id.search_1);
//        searchView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(Travel.this,"hello",Toast.LENGTH_SHORT).show();
////                GridLayoutManager gridLayoutManager = new GridLayoutManager(Travel.this,2);
////                rcvCategory.setLayoutManager(gridLayoutManager);
//            }
//        });
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

//        Bundle bundleReceive = getIntent().getExtras();
//        User user = (User) bundleReceive.get("object_user");
    }

    private void filterList(String newText) {
        List<Item> filterList = new ArrayList<>();
        mItemAdapter = new ItemAdapter_2(this);
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Màn hình đang ở chế độ ngang
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
            rcvCategory.setLayoutManager(gridLayoutManager);
        } else {
            // Màn hình đang ở chế độ dọc
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
            rcvCategory.setLayoutManager(gridLayoutManager);
        }

        Bundle bundle = getIntent().getExtras();
        if(bundle == null) {
            return;
        }
        Category category = (Category) bundle.get("object_category");

        Intent intent = getIntent();

//        mItemAdapter.setData(category.getItems());
        mItemAdapter.setData(getListItem());
        rcvCategory.setAdapter(mItemAdapter);
//        item = getListItem();
//        for (Item item : item) {
//            if(item.getItem_name().toLowerCase().contains(newText.toLowerCase())) {
////                Toast.makeText(this,item.getItem_place(),Toast.LENGTH_SHORT).show();
//                filterList.add(item);
//            }
//        }
//        if(filterList.isEmpty()) {
//            Toast.makeText(this,"No data",Toast.LENGTH_SHORT).show();
//        } else {
//            itemAdapter.setFilterList(filterList);
//        }
    }

    private List<Category> getListCategory(){
        List<Category> listCategory = new ArrayList<>();
        List<Item> list1 = new ArrayList<>();
        List<Item> list2 = new ArrayList<>();
        List<Item> list3 = new ArrayList<>();
        List<Item> list4 = new ArrayList<>();
        list1.add(new Item(1,R.drawable.thanhnhaho,"Thành nhà Hồ","Thanh Hóa"));
        list1.add(new Item(2,R.drawable.avt2, "Cố đô Huê","Thừa Thiên Huế"));
        list1.add(new Item(1,R.drawable.thanhnhaho,"Thành nhà Hồ","Thanh Hóa"));
        list1.add(new Item(2,R.drawable.avt2, "Cố đô Huê","Thừa Thiên Huế"));
        list1.add(new Item(1,R.drawable.thanhnhaho,"Thành nhà Hồ","Thanh Hóa"));
        list1.add(new Item(2,R.drawable.avt2, "Cố đô Huê","Thừa Thiên Huế"));
        list1.add(new Item(1,R.drawable.thanhnhaho,"Thành nhà Hồ","Thanh Hóa"));
        list1.add(new Item(2,R.drawable.avt2, "Cố đô Huê","Thừa Thiên Huế"));
        list1.add(new Item(1,R.drawable.thanhnhaho,"Thành nhà Hồ","Thanh Hóa"));
        list1.add(new Item(2,R.drawable.avt2, "Cố đô Huê","Thừa Thiên Huế"));
        list1.add(new Item(1,R.drawable.thanhnhaho,"Thành nhà Hồ","Thanh Hóa"));
        list1.add(new Item(2,R.drawable.avt2, "Cố đô Huê","Thừa Thiên Huế"));
        list2.add(new Item(1,R.drawable.thanhnhaho,"Thành nhà Hồ","Thanh Hóa"));
        list2.add(new Item(2,R.drawable.avt2, "Cố đô Huê","Thừa Thiên Huế"));
        list2.add(new Item(1,R.drawable.thanhnhaho,"Thành nhà Hồ","Thanh Hóa"));
        list2.add(new Item(2,R.drawable.avt2, "Cố đô Huê","Thừa Thiên Huế"));
        list3.add(new Item(1,R.drawable.thanhnhaho,"Thành nhà Hồ","Thanh Hóa"));
        list3.add(new Item(2,R.drawable.avt2, "Cố đô Huê","Thừa Thiên Huế"));
        list3.add(new Item(1,R.drawable.thanhnhaho,"Thành nhà Hồ","Thanh Hóa"));
        list3.add(new Item(2,R.drawable.avt2, "Cố đô Huê","Thừa Thiên Huế"));
        list4.add(new Item(1,R.drawable.thanhnhaho,"Thành nhà Hồ","Thanh Hóa"));
        list4.add(new Item(2,R.drawable.avt2, "Cố đô Huê","Thừa Thiên Huế"));
        list4.add(new Item(1,R.drawable.thanhnhaho,"Thành nhà Hồ","Thanh Hóa"));
        list4.add(new Item(2,R.drawable.avt2, "Cố đô Huê","Thừa Thiên Huế"));
        listCategory.add(new Category("Xu hướng",list1));
        listCategory.add(new Category("Địa danh nổi tiếng",list2));
        listCategory.add(new Category("Di sản văn hóa",list3));
        listCategory.add(new Category("Ẩm thực",list4));
        return listCategory;
    }

    private List<Item> getListItem(){
        List<Item> list = new ArrayList<>();
        list.add(new Item(1,R.drawable.thanhnhaho,"thanhnhaho","Thanh Hóa"));
        list.add(new Item(2,R.drawable.avt2, "Cố đô HUế","Thừa Thiên Huế"));
        list.add(new Item(1,R.drawable.thanhnhaho,"Thành nhà Hồ","Thanh Hóa"));
        list.add(new Item(2,R.drawable.avt2, "codohue","Thừa Thiên Huế"));
        list.add(new Item(1,R.drawable.thanhnhaho,"Thanhnhaho","Thanh Hóa"));
        list.add(new Item(2,R.drawable.avt2, "Codohue","Thừa Thiên Huế"));
        list.add(new Item(1,R.drawable.thanhnhaho,"Thành nhà Hồ","Thanh Hóa"));
        return list;
    }

}