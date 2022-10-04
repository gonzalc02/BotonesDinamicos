package com.example.botonesdinamicos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button btnC, btnBorrar, btnI;
    EditText nbtn;
    GridLayout tabla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnC = findViewById(R.id.btnCrear);
        btnBorrar = findViewById(R.id.btnBorrar);
        btnI = findViewById(R.id.btnInpar);
        nbtn = findViewById(R.id.editTextNumber);
        tabla = findViewById(R.id.layoutTabla);

        btnI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<View> botones = tabla.getTouchables();
                Iterator<View> iterator = botones.iterator();

                while (iterator.hasNext()){
                    View v = iterator.next();
                    if(v instanceof Button){
                        String[] cadenas = ((Button) v).getText().toString().split(" ");
                        int numero = Integer.parseInt(cadenas[1]);
                        if(numero%2!=0){
                            tabla.removeView(v);
                        }
                    }
                }


            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tabla.removeAllViews();
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cantidad = Integer.parseInt(nbtn.getText().toString());

                for(int i = 0; i < cantidad; i++){
                    Button botonAux = new Button(MainActivity.this);
                    botonAux.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                    botonAux.setText("Boton " + (i+1));
                    botonAux.setBackgroundColor(dameColorAleatorio());
                    tabla.addView(botonAux);

                    int variable = i;

                    botonAux.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast toast = Toast.makeText(getApplicationContext(),"Boton " +variable, Toast.LENGTH_LONG);
                            toast.show();
                        }
                    });

                }
            }
        });


    }
    int dameColorAleatorio(){
        Random ramdom = new Random();
        return Color.argb(255, ramdom.nextInt(256),ramdom.nextInt(256),ramdom.nextInt(256));
    }
}