package com.example.pmdm.ut06.Navidad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pmdm.R;

public class dulceNavidad extends AppCompatActivity {
    RecyclerView recyclerView;
    dulceAdapte adapte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dulce_navidad);

        recyclerView = (RecyclerView) findViewById(R.id.dulceRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(dulceNavidad.this.getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        adapte = new dulceAdapte(dulce.generateDulces());
        recyclerView.setAdapter(adapte);
    }
}