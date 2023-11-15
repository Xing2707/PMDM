package com.example.pmdm.ut04.Ej1;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pmdm.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HolaMundo4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HolaMundo4 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final double COLOR_RANGE = 256;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HolaMundo4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HolaMundo4.
     */
    // TODO: Rename and change types and number of parameters
    public static HolaMundo4 newInstance(String param1, String param2) {
        HolaMundo4 fragment = new HolaMundo4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    TextView ut4e1tv4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_hola_mundo4, container, false);
        ut4e1tv4 = layout.findViewById(R.id.ut4ej1tv4);
        ut4e1tv4.setOnClickListener(view -> {
            ut4e1tv4.setBackgroundColor(Color.argb(
                    (int)(Math.random() * COLOR_RANGE),
                    (int)(Math.random() * COLOR_RANGE),
                    (int)(Math.random() * COLOR_RANGE),
                    (int)(Math.random() * COLOR_RANGE)
            ));
            ut4e1tv4.setText("Hola Mundo!!!");
        });
        return layout;
    }
}