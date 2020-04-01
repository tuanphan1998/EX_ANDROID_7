package com.example.bai009_thuc_hanh_intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private static final  int SECONDARY = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // anh xa
        btn1 = findViewById(R.id.btn1);
        // click kiem tra
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getdataa
                Intent intent = new Intent(MainActivity.this , Main2Activity.class);
                startActivityForResult(intent , SECONDARY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == SECONDARY)
        {
            if(resultCode == RESULT_OK)
            {
                String txt =data.getStringExtra("ten");
                String txt2 =data.getStringExtra("quequan");
                String txt3 =data.getStringExtra("chucvu");
                TextView txt11 = (TextView)findViewById(R.id.txt11);
                txt11.setText(txt);
                TextView txt12 = (TextView)findViewById(R.id.txt12);
                txt12.setText(txt2);
                TextView txt13 = (TextView)findViewById(R.id.txt13);
                txt13.setText(txt3);
            }
        }
    }
}
