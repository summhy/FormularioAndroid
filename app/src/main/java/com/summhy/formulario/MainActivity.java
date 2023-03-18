package com.summhy.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.summhy.formulario.Models.Calificacion;

public class MainActivity extends AppCompatActivity {

    private ListView lstNotas;
    private EditText curso, nota;
    private TextView txtTituloPromedio, txtPromedio;
    private ArrayAdapter adaptador;
    private Calificacion calificacion;
    private Button btnAgregar, btnIniciar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        curso = findViewById(R.id.edtCurso);
        btnAgregar = findViewById(R.id.btnAgregar);
        nota = findViewById(R.id.edtNota);
        lstNotas = (ListView) findViewById(R.id.LstNotas);
        txtTituloPromedio = findViewById(R.id.txtTituloPromedio);
        txtPromedio = findViewById(R.id.txtPromedio);
        btnIniciar = findViewById(R.id.btnInicio);

    }
    public void crear(View v){

        calificacion =  new Calificacion(curso.getText().toString());
        btnAgregar.setVisibility(View.VISIBLE);
        btnIniciar.setVisibility(View.INVISIBLE);
        nota.setVisibility(View.VISIBLE);
        lstNotas.setVisibility(View.VISIBLE);
        txtTituloPromedio.setVisibility(View.VISIBLE);
        txtPromedio.setVisibility(View.VISIBLE);
        curso.setEnabled(false);
    }
    public void agregar(View v){
        calificacion.agregarNota(Float.parseFloat(nota.getText().toString()));
        adaptador=new ArrayAdapter(this, android.R.layout.simple_list_item_1, calificacion.getNotas());
        lstNotas.setAdapter(adaptador);
        txtPromedio.setText(String.valueOf(calificacion.promedio()));
    }
}