package com.example.prueba2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.prueba2.adap.ListaUsuarioAdap;
import com.example.prueba2.db.DbHelper;
import com.example.prueba2.db.DbUsuarios;
import com.example.prueba2.entidades.Usuario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView listaUsuarios;
    ArrayList<Usuario> listaArrayUsuarios;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaUsuarios = findViewById(R.id.listaUsuarios);
        listaUsuarios.setLayoutManager(new LinearLayoutManager(null));

        DbUsuarios dbUsuarios = new DbUsuarios(MainActivity.this);
        listaArrayUsuarios = new ArrayList<>();

        ListaUsuarioAdap adapter = new ListaUsuarioAdap(dbUsuarios.mostrarUsuarios());
        listaUsuarios.setAdapter(adapter);


    }


    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuNew:
                nuevoRegis();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void nuevoRegis(){
        Intent intent = new Intent(this, InsertUsuario.class);
        startActivity(intent);
    }

}