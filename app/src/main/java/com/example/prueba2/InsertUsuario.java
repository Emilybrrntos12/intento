package com.example.prueba2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prueba2.db.DbUsuarios;

public class InsertUsuario extends AppCompatActivity {

    EditText txtNomIn, txtContraIn;
    Button btInUsu;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_usuario);

        txtNomIn = findViewById(R.id.txtNomIn);
        txtContraIn = findViewById(R.id.txtContraIn);
        btInUsu =  findViewById(R.id.btInUsu);

        btInUsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbUsuarios dbUsuarios = new DbUsuarios(InsertUsuario.this);

                long id = dbUsuarios.insertUsu(txtNomIn.getText().toString(), txtContraIn.getText().toString());

                if(id >0){
                    Toast.makeText(InsertUsuario.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
                    borrar();
                }else{
                    Toast.makeText(InsertUsuario.this, "EROOOOR", Toast.LENGTH_LONG).show();
                    borrar();
                }

            }
        });

    }

    private void borrar(){
        txtContraIn.setText("");
        txtNomIn.setText("");
    }
}