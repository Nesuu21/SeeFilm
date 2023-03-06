package com.example.seefilm;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.SeriesViewHolder>{

    private int series;
    private ArrayList <Peliculas> listseries;
    private LayoutInflater  inflater;
    private FragmentTransaction ft ;


    private ArrayList <Peliculas> listaOriginal;

    public RecyclerAdapter(ArrayList lista, Context context, FragmentTransaction ft){
        inflater = LayoutInflater.from(context);
        listseries=lista;
        listaOriginal=new ArrayList<>();
        listaOriginal.addAll(listseries);
        this.ft=ft;
    }

    public RecyclerAdapter() {
    }

    @NonNull
    @Override
    public SeriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycler_series_row, null);

        SeriesViewHolder viewHolder = new SeriesViewHolder(view);

        return viewHolder;
    }

    public void filterSV(String busqueda){
        if(busqueda.length()==0){
            listseries.clear();
            listseries.addAll(listaOriginal);
        } else {
            listseries.clear();
            for (Peliculas p: listaOriginal) {
                if (p.getName().toLowerCase().contains(busqueda.toLowerCase())){
                    listseries.add(p);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull SeriesViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.bind(listseries.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trailerPeli tp = new trailerPeli(listseries.get(position).getName(),listseries.get(position).getDescription(),listseries.get(position).getTrailer());
                ft.replace(R.id.fragmentContainerView,tp).commit();
                ft.addToBackStack(null);
            }
        });

    }

    public int getItemCount() {return listseries.size();}

    public void setItems(ArrayList<Peliculas> items){listseries=items;}

    public class SeriesViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView description;
        ImageView portada;

        public SeriesViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo= itemView.findViewById(R.id.titulo);
            description=itemView.findViewById(R.id.description);
            portada = itemView.findViewById(R.id.imagenportada);


        }

        public void bind(final Peliculas pelicula) {
            titulo.setText(pelicula.getName());
            description.setText(pelicula.getDescription());
            portada.setImageResource(pelicula.getImgurl());
        }
    }


}