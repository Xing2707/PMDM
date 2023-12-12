package com.example.pmdm.ut04.Ej4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pmdm.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link u4e4ContadorPinpon#newInstance} factory method to
 * create an instance of this fragment.
 */
public class u4e4ContadorPinpon extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private static final int PUNTO_INICIO = 0;
    private int puntos;

    public u4e4ContadorPinpon() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment u4e4ContadorPinpon.
     */
    // TODO: Rename and change types and number of parameters
    public static u4e4ContadorPinpon newInstance(String param1, String param2) {
        u4e4ContadorPinpon fragment = new u4e4ContadorPinpon();
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
    TextView u4e4Fragmetv1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_u4e4_contador_pinpon, container, false);
        u4e4Fragmetv1 = layout.findViewById(R.id.u4e4Fragmetv1);
        u4e4Fragmetv1.setOnClickListener(view ->{
            if(!u4e4Fragmetv1.getText().toString().isEmpty()){
                puntos++;
                if(observer != null){
                    observer.puntoActualizado(puntos);
                    u4e4Fragmetv1.setText(String.valueOf(puntos));
                }
            }
        });
        return layout;
    }

    public void desactivarView(){
        u4e4Fragmetv1.setEnabled(false);
    }
    public void inicializarPartido(){
        if(u4e4Fragmetv1.getText().toString().isEmpty()){
            puntos = PUNTO_INICIO;
            u4e4Fragmetv1.setText(String.valueOf(puntos));
        }
    }

    public interface seguimientoPuntos{
        public void puntoActualizado(int puntos);
    }
    seguimientoPuntos observer;
    public void setPuntoListener(seguimientoPuntos recivido){
        observer = recivido;
    }
}