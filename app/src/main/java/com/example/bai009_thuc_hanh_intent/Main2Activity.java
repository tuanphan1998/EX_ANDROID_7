package com.example.bai009_thuc_hanh_intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private ListView lv;
    // tao doi tuong mang
    private List<SinhVien> ListSinhVien = new ArrayList<>();
    // tao adapter
    private ArrayAdapter<SinhVien> adt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv = findViewById(R.id.lisview1);
        adt = new ArrayAdapter<SinhVien>(Main2Activity.this , 0 , ListSinhVien)
        {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.itemlistview , null);
                // anh xa data
                TextView txt1 =convertView.findViewById(R.id.txt1);
                TextView txt2 =convertView.findViewById(R.id.txt2);
                TextView txt3 =convertView.findViewById(R.id.txt3);
                //lay gia tri
                SinhVien s = ListSinhVien.get(position);
                txt1.setText(s.getName());
                txt2.setText(s.getQuequan());
                txt3.setText(s.getChucvu());
                return convertView;
            }
        };
        lv.setAdapter(adt);
        LoadData();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SinhVien s = ListSinhVien.get(position);
                Intent intent =new Intent();
                intent.putExtra("ten" , s.getName());
                intent.putExtra("quequan" , s.getQuequan());
                intent.putExtra("chucvu" , s.getChucvu());
                setResult(RESULT_OK , intent);
                finish();
            }
        });
    }
    private void LoadData()
    {
        for (int i = 0 ; i < 14 ; i++)
        {
            SinhVien s = new SinhVien();
            s.setName("Tuanphan" + i);
            s.setQuequan("hung yen" + i);
            s.setChucvu("lap trinh vien" + i);
            ListSinhVien.add(s);
            adt.notifyDataSetChanged();
        }
    }
}
