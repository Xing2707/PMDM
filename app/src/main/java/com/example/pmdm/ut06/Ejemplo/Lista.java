package com.example.pmdm.ut06.Ejemplo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.pmdm.R;

public class Lista extends AppCompatActivity {
    RecyclerView rcView;
    Button add;
    PartidoAdapte adapte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        rcView = (RecyclerView) findViewById(R.id.ut06EjmRecycleV);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Lista.this.getApplicationContext());
        rcView.setLayoutManager(layoutManager);
        adapte = new PartidoAdapte(Partido.generatePartidos(Partido.PARTIDO_INICIAL));
        add = findViewById(R.id.ut06ButtonAdd);
        rcView.setAdapter(adapte);
        add.setOnClickListener(view ->{
            adapte.add(Partido.generatePartidos(Partido.PARTIDO_INICIAL));
        });
    }
}