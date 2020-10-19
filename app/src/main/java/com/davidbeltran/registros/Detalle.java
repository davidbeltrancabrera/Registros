package com.davidbeltran.registros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Detalle extends AppCompatActivity {
    private TextView Textv;
    private TextView Textv2;
    private TextView Textv3;
    private TextView Textv4;
    private TextView Textv5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Textv = (TextView)findViewById(R.id.tvNombre);
        Textv2 = (TextView)findViewById(R.id.tvFecha);
        Textv3 = (TextView)findViewById(R.id.tvTelefono);
        Textv4 = (TextView)findViewById(R.id.tvEmail);
        Textv5 = (TextView)findViewById(R.id.tvDescripcion);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();

        if(b!=null)
        {
            String j =(String) b.get("nombre");
            String j2 =(String) b.get("fecha");
            String j3 =(String) b.get("telefono");
            String j4 =(String) b.get("correo");
            String j5 =(String) b.get("descripcion");
            Textv.setText(j);
            Textv2.setText(j2);
            Textv3.setText(j3);
            Textv4.setText(j4);
            Textv5.setText(j5);
        }
    }
    public void regresarAtras(View button){
        super.onBackPressed();
    }
}