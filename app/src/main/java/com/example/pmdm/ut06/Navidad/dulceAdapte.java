package com.example.pmdm.ut06.Navidad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm.R;
import com.example.pmdm.ut06.Ejemplo.PartidoAdapte;

import java.util.ArrayList;
import java.util.Arrays;

public class dulceAdapte extends RecyclerView.Adapter<dulceAdapte.ViewHolder> {
    private ArrayList<dulce> datos;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView dulceNombre;
        private final TextView dulceFruto;
        private final TextView dulceCaloria;
        public ViewHolder(View view){
            super(view);

            dulceNombre = (TextView) view.findViewById(R.id.dulceNombre);
            dulceFruto = (TextView) view.findViewById(R.id.dulceFruto);
            dulceCaloria = (TextView) view.findViewById(R.id.dulceCaloria);
        }
        public TextView getDulceNombre(){return dulceNombre;}
        public TextView getDulceFruto(){return dulceFruto;}
        public TextView getDulceCaloria(){return dulceCaloria;}
    }

    public dulceAdapte(dulce[] dataSet){
        datos = new ArrayList<dulce>();
        add(dataSet);
    }

    public void add(dulce[] dataSet){
        datos.addAll(Arrays.asList(dataSet));
        notifyDataSetChanged();
    }

    @Override
    public dulceAdapte.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_dulce,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(dulceAdapte.ViewHolder holder, int position) {
        holder.getDulceNombre().setText(datos.get(position).getNombre());
        holder.getDulceFruto().setText(datos.get(position).getFrutoSeco());
        holder.getDulceCaloria().setText(datos.get(position).getCaloria());
    }

    @Override
    public int getItemCount() { return datos.size();}
}
