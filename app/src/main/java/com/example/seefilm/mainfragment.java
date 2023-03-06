package com.example.seefilm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mainfragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mainfragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_checkedimg = "param1";
    private static final String ARG_myRv = "param2";

    // TODO: Rename and change types of parameters
    private RecyclerView myRv;
    private ArrayList<Peliculas> peliculasList;

    public mainfragment() {
        // Required empty public constructor
    }

    public static mainfragment newInstance() {
        mainfragment fragment = new mainfragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mainfragment, container, false);

        //Inicializacion de search view
        SearchView searchView=view.findViewById(R.id.buscador);
        searchView.setIconifiedByDefault(false);
        searchView.clearFocus();

        //Lista Peliculas
        peliculasList=new ArrayList<>();
        peliculasList.add(new Peliculas("Merlí","https://www.youtube.com/embed/edqD0r_fpps",R.drawable.portada_merli,"El profesor de filosofía Merlí Bergeron (Francesc Orella) escoge a un grupo de alumnos de bachillerato para convertirlos en \"los peripatéticos del siglo XXI\". Como si se tratara de un nuevo Aristóteles, Merlí les enseña a cuestionar las cosas y a reflexionar. Pero, por su carácter irónico e irritante, despierta antipatías en el instituto, porque no todos los profesores están dispuestos a aguantar sus manías. Ni tampoco su hijo, Bruno, el alumno más difícil que ha tenido jamás, y con el que intentará mejorar su relación."));
        peliculasList.add(new Peliculas("Sandman","https://www.youtube.com/embed/03hK9bC-1dU",R.drawable.portada_sandman,"Adaptación del aclamado cómic de Neil Gaiman, que mezcla el mito moderno y la fantasía tenebrosa, y en el que la ficción contemporánea, el drama histórico y la leyenda se entrelazan. 'The Sandman' sigue a las personas y los lugares afectados por Morfeo, el Rey del Sueño, mientras repara los errores cósmicos -y humanos- que ha cometido durante su vasta existencia."));
        peliculasList.add(new Peliculas("The Witcher","https://www.youtube.com/embed/ETY44yszyNc",R.drawable.portada_the_witcher,"Geralt de Rivia, un cazador de monstruos mutante, viaja en pos de su destino por un mundo turbulento en el que, a menudo, los humanos son peores que las bestias. "));
        peliculasList.add(new Peliculas("Vikingos","https://www.youtube.com/embed/CLVZmXzeZx8",R.drawable.portada_vikingos,"Narra las aventuras del héroe Ragnar Lothbrok, de sus hermanos vikingos y su familia, cuando él se subleva para convertirse en el rey de las tribus vikingas. Además de ser un guerrero valiente, Ragnar encarna las tradiciones nórdicas de la devoción a los dioses."));
        peliculasList.add(new Peliculas("Harry Potter","https://www.youtube.com/embed/ZgrCZVjPg9g",R.drawable.portada_harrypotter,"El día en que cumple once años, Harry Potter se entera de que es hijo de dos destacados hechiceros, de los que ha heredado poderes mágicos. En la escuela Hogwarts de Magia y Hechicería, donde se educa con otros niños que también tienen poderes especiales, aprenderá todo lo necesario para ser mago."));
        peliculasList.add(new Peliculas("Un Sueño Posible","https://www.youtube.com/embed/3XgiNIHHybA",R.drawable.portada_unsuenioposible,"Basada en una historia real. Michael Oher, un joven negro sin hogar, es acogido por los Touhy, una rica familia blanca, dispuesta a darle todo su apoyo para que pueda triunfar tanto como jugador de fútbol americano como en su vida privada. Por su parte, Oher también influirá con su presencia en la vida de la familia Touhy."));

        FragmentTransaction ft = getParentFragmentManager().beginTransaction();

        myRv= (RecyclerView) view.findViewById(R.id.rvSeries);
        myRv.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        myRv.setLayoutManager (linearLayoutManager);

        RecyclerAdapter myAdapter = new RecyclerAdapter(peliculasList,getContext(),ft);
        myRv.setAdapter (myAdapter);

        //listener del buscador
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                myAdapter.filterSV(newText);
                return false;
            }
        });

        return view;
    }
}