package com.davidbeltran.registros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String CERO = "0";
    private static final String BARRA = "/";

    //Calendario para obtener fecha & hora
    public final Calendar c = Calendar.getInstance();

    //Variables para obtener la fecha
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    //Widgets
    EditText editFecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Widget EditText donde se mostrara la fecha obtenida
        editFecha = (EditText) findViewById(R.id.editFecha);
        //Widget ImageButton del cual usaremos el evento clic para obtener la fecha
       // ibObtenerFecha = (ImageButton) findViewById(R.id.ib_obtener_fecha);
        //Evento setOnClickListener - clic
        editFecha.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.editFecha:
                obtenerFecha();
                break;
        }
    }
    private void obtenerFecha(){
        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                final int mesActual = month + 1;
                //Formateo el día obtenido: antepone el 0 si son menores de 10
                String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                //Formateo el mes obtenido: antepone el 0 si son menores de 10
                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
                //Muestro la fecha con el formato deseado
                editFecha.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);


            }
            //Estos valores deben ir en ese orden, de lo contrario no mostrara la fecha actual
            /**
             *También puede cargar los valores que usted desee
             */
        },anio, mes, dia);
        //Muestro el widget
        recogerFecha.show();

    }

    public void enviarDatos(View button){
        final EditText nombreField = (EditText) findViewById(R.id.editNombre);
        String nombre = nombreField.getText().toString();

        final EditText fechaField = (EditText) findViewById(R.id.editFecha);
        String fecha = fechaField.getText().toString();

        final EditText telefonoField = (EditText) findViewById(R.id.editTellefono);
        String telefono = telefonoField.getText().toString();

        final EditText emailField = (EditText) findViewById(R.id.editEmail);
        String correo = emailField.getText().toString();

        final EditText descripcionField = (EditText) findViewById(R.id.editDescripcion);
        String descripcion = descripcionField.getText().toString();

        Intent intent = new Intent(MainActivity.this,Detalle.class);
        intent.putExtra("nombre", nombre);
        intent.putExtra("fecha", fecha);
        intent.putExtra("telefono", telefono);
        intent.putExtra("correo", correo);
        intent.putExtra("descripcion", descripcion);
        startActivity(intent);

        //System.out.println(nombre);
    }

}

