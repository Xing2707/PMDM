package com.example.pmdm.ut03.Ej8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm.R;

public class u3e8ObjetoSerializableR extends AppCompatActivity {
    TextView u3e8bsrtv1;
    Button u3e8bsrbtVolver;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3e8_objeto_serializable_r);
        u3e8bsrtv1 = findViewById(R.id.u3e8bsrtv1);
        u3e8bsrbtVolver = findViewById(R.id.u3e8bsrbtVolver);

        Monstruo monstruo;
        bundle = getIntent().getExtras();
        monstruo =(Monstruo) bundle.getSerializable(u3e8ObjetoSerializable.INTENT_KEY);

        u3e8bsrtv1.setTextColor(monstruo.getColor());
        u3e8bsrtv1.setText(monstruo.toString());

        u3e8bsrbtVolver.setOnClickListener(view -> {
            setResult(Activity.RESULT_OK);
            finish();
        });

    }
}