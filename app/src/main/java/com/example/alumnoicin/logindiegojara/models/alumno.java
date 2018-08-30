package com.example.alumnoicin.logindiegojara.models;


import com.example.alumnoicin.logindiegojara.application.MyApplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class alumno extends RealmObject {
    @PrimaryKey
    private int id;
    private String rut;
    private String nombre;
    private String direccion;
    private int sueldo;
    private int edad;
    private String cargo;

    public  alumno(){}

    public alumno(String Rut, String Name,  String Direccion, int Sueldo, String Cargo, int Edad){
        id = MyApplication.alumnoID.incrementAndGet();
        rut = Rut;
        nombre = Name;
        direccion = Direccion;
        sueldo=Sueldo;
        cargo = Cargo;
        edad=Edad;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String nombre) {
        this.direccion = direccion;
    }

    public int getSueldo() { return sueldo; }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String nombre) {
        this.cargo = cargo;
    }

    public int getEdad() { return edad; }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}


