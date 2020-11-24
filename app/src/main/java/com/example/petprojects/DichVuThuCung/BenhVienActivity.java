package com.example.petprojects.DichVuThuCung;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.example.petprojects.Adapter.BenhVienAdapter;
import com.example.petprojects.CaiDat.CaiDatActivity;
import com.example.petprojects.ModelThuCung.BenhVien;
import com.example.petprojects.R;
import com.example.petprojects.SQLite.BenhVienDAO;
import com.example.petprojects.SQLite.SQLiteDB;
import com.example.petprojects.TinTucThuCung.TinTucThuCungActivity;
import com.example.petprojects.TrangChu.TrangChuActivity;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;


public class BenhVienActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recBenhVien;
    BenhVienAdapter benhVienAdapter;
    private SQLiteDB sqLiteDB;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benh_vien);
        sqLiteDB = new SQLiteDB(this);
        BenhVienDAO benhVienDAO = new BenhVienDAO(sqLiteDB);
        recBenhVien = findViewById(R.id.recBenhVien);
//        delete();
        Menu();
        ThemBenhVien();
        benhVienAdapter = new BenhVienAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recBenhVien.setLayoutManager(gridLayoutManager);
        List<BenhVien> benhVienList = benhVienDAO.getAllBenhVien();
        benhVienAdapter.setData(benhVienList);
        recBenhVien.setAdapter(benhVienAdapter);
    }

    private void Menu() {
        toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle("Bệnh Viện Thú Cưng");
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerBenhVien);
        navigationView = findViewById(R.id.navigation_view);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    //    private List<BenhVien> benhVienList() {
//        List<BenhVien> benhVienList = new ArrayList<>();
//        BenhVien benhVien = new BenhVien("BV01", "Bệnh Viện Thú Cưng", "Số 3 Nguyễn Trải", R.drawable.hospital_item))
//        ;
////        benhVienList.add(new BenhVien("BV01", "Thú Cưng Hà Nội", "Số 3 Nguyễn Trải", R.drawable.hospital_item));
////        benhVienList.add(new BenhVien("BV01", "Bệnh Viện Lan Anh", "Số 3 Nguyễn Trải", R.drawable.hospital_item));
////        benhVienList.add(new BenhVien("BV01", "Pets Hospital", "Số 3 Nguyễn Trải", R.drawable.hospital_item));
////        benhVienList.add(new BenhVien("BV01", "Animal Viet Nam", "Số 3 Nguyễn Trải", R.drawable.hospital_item));
//        BenhVienDAO benhVienDAO = new BenhVienDAO(sqLiteDB);
//        benhVienDAO.themBenhVien(benhVien);
//        return benhVienList;
//
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home_pet) {
            startActivity(new Intent(BenhVienActivity.this, TrangChuActivity.class));
        } else if (item.getItemId() == R.id.news_pet) {
            startActivity(new Intent(BenhVienActivity.this, TinTucThuCungActivity.class));
        } else if (item.getItemId() == R.id.hospital_pet) {
            startActivity(new Intent(BenhVienActivity.this, BenhVienActivity.class));
        } else if (item.getItemId() == R.id.shop_pet) {
            startActivity(new Intent(BenhVienActivity.this, ShopThuCungActivity.class));
        } else if (item.getItemId() == R.id.setup) {
            startActivity(new Intent(BenhVienActivity.this, CaiDatActivity.class));
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void ThemBenhVien() {
        BenhVien benhVien = new BenhVien("BV01", "Bệnh Viện Ba Lan", "Hà Nội", R.drawable.hospital_item);
        BenhVien benhVien2 = new BenhVien("BV02", "Bệnh Viện Nam Từ Liêm", "TP. Hồ Chí Minh", R.drawable.hospital_item);
        BenhVien benhVien3 = new BenhVien("BV03", "Bệnh Viện Ba Lan", "Hà Nội", R.drawable.hospital_item);
        BenhVien benhVien4 = new BenhVien("BV04", "Bệnh Viện Nam Từ Liêm", "Hà Nội", R.drawable.hospital_item);
        BenhVien benhVien5 = new BenhVien("BV05", "Bệnh Viện Ba Lan", "TP. Hồ Chí Minh", R.drawable.hospital_item);
        BenhVien benhVien6 = new BenhVien("BV06", "Bệnh Viện Ba Lan", "Hà Nội", R.drawable.hospital_item);
        BenhVien benhVien7 = new BenhVien("BV07", "Bệnh Viện Nam Từ Liêm", "TP. Hồ Chí Minh", R.drawable.hospital_item);


        BenhVienDAO benhVienDAO = new BenhVienDAO(sqLiteDB);
        benhVienDAO.themBenhVien(benhVien);
        benhVienDAO.themBenhVien(benhVien2);
        benhVienDAO.themBenhVien(benhVien3);
        benhVienDAO.themBenhVien(benhVien4);
        benhVienDAO.themBenhVien(benhVien5);
        benhVienDAO.themBenhVien(benhVien6);
        benhVienDAO.themBenhVien(benhVien7);

    }

    private void delete() {
        String benhVien[] = new String[]{"BV01", "BV02", "BV03", "BV04"};
        BenhVienDAO benhVienDAO = new BenhVienDAO(sqLiteDB);
        for (int i = 0; i < benhVien.length; i++) {
            benhVienDAO.xoaBenhVien(benhVien[i]);
        }

    }
}