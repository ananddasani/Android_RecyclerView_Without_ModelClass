package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridLayout;

import com.example.myrecyclerview.Adapter.CustomAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] data = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        //set the layout
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        //give data to adapter
        customAdapter = new CustomAdapter(data, getApplicationContext());

        //set the adapter at the end
        recyclerView.setAdapter(customAdapter);
    }
}