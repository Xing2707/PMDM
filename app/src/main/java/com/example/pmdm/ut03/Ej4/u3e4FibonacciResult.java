package com.example.pmdm.ut03.Ej4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm.R;

import java.util.ArrayList;

public class u3e4FibonacciResult extends AppCompatActivity {
    TextView u3e4twSumaResult;
    Button u3e3btOK;
    Bundle bundle;
    private static Intent intent = new Intent();
    private static int total = 0;
    private static ArrayList<String> extasList = new ArrayList<>();
    public static final String ACCEPT_KEY = "ACEPTA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3e4_fibonacci_result);
        u3e4twSumaResult = findViewById(R.id.u3e4twSumaResult);
        u3e3btOK = findViewById(R.id.u3e3btOK);
        bundle = getIntent().getExtras();
        extasList = bundle.getStringArrayList(u3e4Fibonacci.INTENTKEY);
        extasList.forEach( value ->{
            total += Integer.parseInt(value);
        });
        u3e4twSumaResult.setText(String.valueOf(total));
        total = 0;

        u3e3btOK.setOnClickListener(view -> {
            intent.putExtra(ACCEPT_KEY,u3e4twSumaResult.getText().toString());
            setResult(Activity.RESULT_OK,intent);
            finish();
            extasList.clear();
        });

    }
}