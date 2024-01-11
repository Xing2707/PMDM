package com.example.pmdm.ut06.Ejemplo;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm.R;

import java.util.ArrayList;
import java.util.Arrays;

public class PartidoAdapte extends RecyclerView.Adapter<PartidoAdapte.ViewHolder> {

    private ArrayList<Partido> datos;

    public static class  ViewHolder extends RecyclerView.ViewHolder{
        private final TextView partido;
        private final TextView resultado;

        public ViewHolder(View view){
            super(view);

            partido = (TextView) view.findViewById(R.id.partidoNombre);
            resultado = (TextView) view.findViewById(R.id.partidoResutado);
        }
        public TextView getTextPartido(){
            return partido;
        }
        public TextView getTextResultado(){
            return resultado;
        }
    }

    public PartidoAdapte(Partido[] dataSet){
        datos = new ArrayList<Partido>();
        add(dataSet);
    }

    public void add(Partido[] dataSet){
        datos.addAll(Arrays.asList(dataSet));
        notifyDataSetChanged();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_partido,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {
        holder.getTextPartido().setText(datos.get(position).local + " : " + datos.get(position).visitante);
        holder.getTextResultado().setText(datos.get(position).resultado);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }
}
