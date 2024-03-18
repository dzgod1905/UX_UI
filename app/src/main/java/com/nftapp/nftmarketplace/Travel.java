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
import android.widget.TextView;
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
    private ImageView no_result;
    private TextView no_result_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_page);
        back_button = findViewById(R.id.back_button);
        no_result = findViewById(R.id.no_result_1);
        no_result_text = findViewById(R.id.no_result_text_1);
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
        if (newText.equals("")) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
            rcvCategory.setLayoutManager(linearLayoutManager);
            categoryAdapter.setData(getListCategory());
            rcvCategory.setAdapter(categoryAdapter);
            rcvCategory.setVisibility(View.VISIBLE);
            no_result.setVisibility(View.GONE);
            no_result_text.setVisibility(View.GONE);
        } else {
            List<Item> filterList = new ArrayList<>();
            item = getListItem();
            mItemAdapter = new ItemAdapter_2(this);
//            mItemAdapter.setData(getListItem());
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
            rcvCategory.setAdapter(mItemAdapter);
            for (Item item : item) {
                if (item.getItem_name().toLowerCase().contains(newText.toLowerCase())) {
                    filterList.add(item);
                }
            }
            if (filterList.isEmpty()) {
                rcvCategory.setVisibility(View.GONE);
                no_result.setVisibility(View.VISIBLE);
                no_result_text.setVisibility(View.VISIBLE);

            } else {
                rcvCategory.setVisibility(View.VISIBLE);
                no_result.setVisibility(View.GONE);
                no_result_text.setVisibility(View.GONE);
                mItemAdapter.setFilterList(filterList);
            }
        }



        Bundle bundle = getIntent().getExtras();
        if(bundle == null) {
            return;
        }
        Category category = (Category) bundle.get("object_category");

        Intent intent = getIntent();

//        mItemAdapter.setData(category.getItems());

    }

    private List<Category> getListCategory(){
        List<Category> listCategory = new ArrayList<>();
        List<Item> list1 = new ArrayList<>();
        List<Item> list2 = new ArrayList<>();
        List<Item> list3 = new ArrayList<>();
        List<Item> list4 = new ArrayList<>();
        list1.add(new Item(1,R.drawable.thanhnhaho,"Thành nhà Hồ","Thanh Hóa"));
        list1.add(new Item(2,R.drawable.avt2, "Cố đô Huế","Thừa Thiên Huế"));
        list1.add(new Item(1,R.drawable.thanhnhaho,"Lăng chủ tịch","Hà Nội"));
        list1.add(new Item(2,R.drawable.avt2, "Thành cổ Quảng Trị","Quảng Trị"));
        list1.add(new Item(1,R.drawable.thanhnhaho,"Dinh độc lập","Tp.Hồ Chí Minh"));
        list1.add(new Item(2,R.drawable.avt2, "Nhà tù Hỏa Lò","Hà Nội"));
        list1.add(new Item(1,R.drawable.thanhnhaho,"Đền Hùng","Phú Thọ"));
        list1.add(new Item(2,R.drawable.avt2, "Thành Cổ Loa","Đông Anh"));
        list1.add(new Item(1,R.drawable.thanhnhaho,"Hồ Gươm","Hà Nội"));
        list1.add(new Item(2,R.drawable.avt2, "Cố đô Hoa Lư","Ninh Bình"));
        list1.add(new Item(1,R.drawable.thanhnhaho,"Chiến khu Tân Trào","Tuyên Quang"));
        list1.add(new Item(2,R.drawable.avt2, "Khu di tích Pác Bó","Cao Bằng"));
        list2.add(new Item(1,R.drawable.thanhnhaho,"Đền Ngọc Sơn","Hà Nội"));
        list2.add(new Item(2,R.drawable.avt2, "Thiền viện Trúc lâm Yên Tử","Quảng Ninh"));
        list2.add(new Item(1,R.drawable.thanhnhaho,"Đền Trần","Nam Định"));
        list2.add(new Item(2,R.drawable.avt2, "Văn miếu - Quốc Tử Giám","Hà Nội"));
        list3.add(new Item(1,R.drawable.thanhnhaho,"Vịnh Hạ Long","Quảng Ninh"));
        list3.add(new Item(2,R.drawable.avt2, "Phong Nha Kẻ Bàng","Quảng Bình"));
        list3.add(new Item(1,R.drawable.thanhnhaho,"Phố cổ Hội An","Quảng Nam"));
        list3.add(new Item(2,R.drawable.avt2, "Thánh địa Mỹ Sơn","Quảng Nam"));
        list4.add(new Item(1,R.drawable.thanhnhaho,"Phở xưa","Hà Nội"));
        list4.add(new Item(2,R.drawable.avt2, "Nem chua","Thanh Hóa"));
        list4.add(new Item(1,R.drawable.thanhnhaho,"Bánh cáy","Thái Bình"));
        list4.add(new Item(2,R.drawable.avt2, "Bánh đậu xanh","Hải dương"));
        listCategory.add(new Category("Xu hướng",list1));
        listCategory.add(new Category("Địa danh nổi tiếng",list2));
        listCategory.add(new Category("Di sản văn hóa",list3));
        listCategory.add(new Category("Ẩm thực",list4));
        return listCategory;
    }

    private List<Item> getListItem(){
        List<Item> list = new ArrayList<>();
        list.add(new Item(1,R.drawable.thanhnhaho,"Thành nhà Hồ","Thanh Hóa"));
        list.add(new Item(2,R.drawable.avt2, "Cố đô Huế","Thừa Thiên Huế"));
        list.add(new Item(1,R.drawable.thanhnhaho,"Lăng chủ tịch","Hà Nội"));
        list.add(new Item(2,R.drawable.avt2, "Thành cổ Quảng Trị","Quảng Trị"));
        list.add(new Item(1,R.drawable.thanhnhaho,"Dinh độc lập","Tp.Hồ Chí Minh"));
        list.add(new Item(2,R.drawable.avt2, "Nhà tù Hỏa Lò","Hà Nội"));
        list.add(new Item(1,R.drawable.thanhnhaho,"Đền Hùng","Phú Thọ"));
        list.add(new Item(2,R.drawable.avt2, "Thành Cổ Loa","Đông Anh"));
        list.add(new Item(1,R.drawable.thanhnhaho,"Hồ Gươm","Hà Nội"));
        list.add(new Item(2,R.drawable.avt2, "Cố đô Hoa Lư","Ninh Bình"));
        list.add(new Item(1,R.drawable.thanhnhaho,"Chiến khu Tân Trào","Tuyên Quang"));
        list.add(new Item(2,R.drawable.avt2, "Khu di tích Pác Bó","Cao Bằng"));
        list.add(new Item(1,R.drawable.thanhnhaho,"Đền Ngọc Sơn","Hà Nội"));
        list.add(new Item(2,R.drawable.avt2, "Thiền viện Trúc lâm Yên Tử","Quảng Ninh"));
        list.add(new Item(1,R.drawable.thanhnhaho,"Đền Trần","Nam Định"));
        list.add(new Item(2,R.drawable.avt2, "Văn miếu - Quốc Tử Giám","Hà Nội"));
        list.add(new Item(1,R.drawable.thanhnhaho,"Vịnh Hạ Long","Quảng Ninh"));
        list.add(new Item(2,R.drawable.avt2, "Phong Nha Kẻ Bàng","Quảng Bình"));
        list.add(new Item(1,R.drawable.thanhnhaho,"Phố cổ Hội An","Quảng Nam"));
        list.add(new Item(2,R.drawable.avt2, "Thánh địa Mỹ Sơn","Quảng Nam"));
        list.add(new Item(1,R.drawable.thanhnhaho,"Phở xưa","Hà Nội"));
        list.add(new Item(2,R.drawable.avt2, "Nem chua","Thanh Hóa"));
        list.add(new Item(1,R.drawable.thanhnhaho,"Bánh cáy","Thái Bình"));
        list.add(new Item(2,R.drawable.avt2, "Bánh đậu xanh","Hải dương"));
        return list;
    }

}