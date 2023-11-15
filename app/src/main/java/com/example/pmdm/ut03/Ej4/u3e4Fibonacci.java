package com.example.pmdm.ut03.Ej4;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm.R;

import java.util.ArrayList;

public class u3e4Fibonacci extends AppCompatActivity {
    TextView u3e4twNum1R,u3e4twNum2R;
    Button u3e4btSiguiente;
    ActivityResultLauncher<Intent> launcher;
    private static Intent intent;
    private static final int TWO = 2, ONE = 1, ZERO = 0;
    public static final String INTENTKEY = "sjfhfhdhfkhdsfdfrgthgbtygytygth";
    private ArrayList<String> intentList = new ArrayList<>();
    private static int[] numList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3e4_fibonacci);
        if(numList == null) inicialNum();

        u3e4twNum1R = findViewById(R.id.u3e4twNum1R);
        u3e4twNum2R = findViewById(R.id.u3e4twNum2R);
        u3e4btSiguiente = findViewById(R.id.u3e4btSiguiente);

        u3e4twNum1R.setText(String.valueOf(numList[ZERO]));
        u3e4twNum2R.setText(String.valueOf(numList[ONE]));

        u3e4btSiguiente.setOnClickListener(view -> {
            intentList.add(u3e4twNum1R.getText().toString());
            intentList.add(u3e4twNum2R.getText().toString());
            intent = new Intent(u3e4Fibonacci.this, u3e4FibonacciResult.class);
            intent.putExtra(INTENTKEY,intentList);
            launcher.launch(intent);
            intentList.clear();
        });

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result ->{
            if(result.getResultCode() == Activity.RESULT_OK){
                intent = result.getData();
                numList[ZERO] = numList[ONE];
                numList[ONE] = Integer.parseInt(intent.getStringExtra(u3e4FibonacciResult.ACCEPT_KEY));
                u3e4twNum1R.setText(String.valueOf(numList[ZERO]));
                u3e4twNum2R.setText(String.valueOf(numList[ONE]));
            }
        });
    }

    private static void inicialNum(){
        numList = new int[2];
        for(int i = 0; i < numList.length; i ++){
            numList[i] = ONE;
        }
    }
}