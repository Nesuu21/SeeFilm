package com.example.seefilm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        //FALTA HACER LOS OTROS FRAGMENTOS ENLAZARLOS
        // //Y PREPARAR TODO LO DEMAS


    }
}