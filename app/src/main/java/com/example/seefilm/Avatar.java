package com.example.seefilm;

import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toolbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Avatar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Avatar extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Avatar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Avatar.
     */
    // TODO: Rename and change types and number of parameters
    public static Avatar newInstance(String param1, String param2) {
        Avatar fragment = new Avatar();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_avatar, container, false);

        ImageView avatar1 = view.findViewById(R.id.avatar1);
        ImageView avatar2 = view.findViewById(R.id.avatar2);
        ImageView avatar3 = view.findViewById(R.id.avatar3);
        ImageView avatar4 = view.findViewById(R.id.avatar4);


        avatar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView logoPerfil = view.findViewById(R.id.logoUser);
                logoPerfil.setImageResource(R.drawable.avatar);
                logoPerfil.setVisibility(View.VISIBLE);
            }
        });

        avatar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView logoPerfil = view.findViewById(R.id.logoUser);
                logoPerfil.setImageResource(R.drawable.avatar2);
                logoPerfil.setVisibility(View.VISIBLE);

            }
        });

        avatar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView logoPerfil = view.findViewById(R.id.logoUser);
                logoPerfil.setImageResource(R.drawable.avatar4);
                logoPerfil.setVisibility(View.VISIBLE);

            }
        });

        avatar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView logoPerfil = view.findViewById(R.id.logoUser);
                logoPerfil.setImageResource(R.drawable.avatar3);
                logoPerfil.setVisibility(View.VISIBLE);

            }
        });


        return view;
    }
}