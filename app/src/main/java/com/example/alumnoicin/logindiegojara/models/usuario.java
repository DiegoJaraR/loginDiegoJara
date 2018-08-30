package com.example.alumnoicin.logindiegojara.models;

import com.example.alumnoicin.logindiegojara.application.MyApplication;
import com.example.alumnoicin.logindiegojara.application.MyApplicationUsuario;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class usuario extends RealmObject {

    @PrimaryKey
    private int id;
    private String nombre;
    private String contrasena;

    public  usuario(){}

    public usuario(String name, String Contrasena){
        id = MyApplicationUsuario.usuarioID.incrementAndGet();
        nombre = name;
        contrasena = Contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.contrasena = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setRut(String rut) {
        this.contrasena = contrasena;
    }

}
