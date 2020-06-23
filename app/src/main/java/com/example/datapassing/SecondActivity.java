package com.example.datapassing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.lang.UScript;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private EditText dataEdittext1;
    private EditText dataEdittext2;
    private Button sendDataToFragmentBtn;
    private TextView receiveFirstData;
    private TextView receiveSecondData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setTitle("Second Activity");

        dataEdittext1 = findViewById(R.id.dataEdittext1);
        dataEdittext1 = findViewById(R.id.dataEdittext2);
        sendDataToFragmentBtn = findViewById(R.id.sendDataToFragmentBtn);
        receiveFirstData = findViewById(R.id.receiveFirstData);
        receiveSecondData = findViewById(R.id.receiveSecondData);

        sendDataToFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        Intent getDatafromfirstFragment = getIntent();
        String data1 = getDatafromfirstFragment.getStringExtra("data1");
        String data2 = getDatafromfirstFragment.getStringExtra("data2");

        receiveFirstData.setText(data1);
        receiveSecondData.setText(data2);
    }

}
