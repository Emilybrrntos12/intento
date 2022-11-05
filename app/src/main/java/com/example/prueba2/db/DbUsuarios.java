package com.example.prueba2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.prueba2.entidades.Usuario;

import java.util.ArrayList;

public class DbUsuarios extends DbHelper{

    Context context;

    public DbUsuarios(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertUsu(String nombre, String contra){

        long id=0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("contra", contra);

            id = db.insert(TABLE_USUARIOS, null, values);
        }catch (Exception ex){
            ex.toString();
        }


        return  id;

    }

    public ArrayList<Usuario> mostrarUsuarios(){

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        Usuario usuario = null;
        Cursor cursorUsuarios = null;

        cursorUsuarios = db.rawQuery( "SELECT * FROM " + TABLE_USUARIOS, null);

        if(cursorUsuarios.moveToFirst()){
            do{
                usuario = new Usuario();
                usuario.setId(cursorUsuarios.getInt(0));
                usuario.setNombre(cursorUsuarios.getString(1));
                usuario.setContra(cursorUsuarios.getString(2));
                listaUsuarios.add(usuario);
            }while (cursorUsuarios.moveToNext());
        }
        cursorUsuarios.close();

        return listaUsuarios;

    }

}
