package com.example.seefilm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link trailerPeli#newInstance} factory method to
 * create an instance of this fragment.
 */
public class trailerPeli extends Fragment {

    String urltrailer,titulo,sinopsis;
//listseries.get(position).getName(),listseries.get(position).getDescription(),listseries.get(position).getTrailer()
    public trailerPeli(String titulo, String sinopsis, String trailer) {
        this.sinopsis=sinopsis;
        urltrailer=trailer;
        this.titulo=titulo;
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static trailerPeli newInstance(String trailer, String titulo, String sinopsis) {
        trailerPeli fragment = new trailerPeli(trailer,titulo,sinopsis);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trailer_peli, container, false);

        WebView trailer=view.findViewById(R.id.trailer);
        TextView tvTitulo =view.findViewById(R.id.Titulo);
        TextView tvSinopsis =view.findViewById(R.id.sinopsis);

        tvTitulo.setText(titulo);
        tvSinopsis.setText(sinopsis);
        trailer.getSettings().setJavaScriptEnabled(true);
        trailer.loadUrl(urltrailer);

        FloatingActionButton buttonBack = view.findViewById(R.id.floatingActionButton);

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                mainfragment mf= new mainfragment();
                ft.replace(R.id.fragmentContainerView,mf).commit();
                ft.addToBackStack(null);

            }
        });



        return view;
    }
}