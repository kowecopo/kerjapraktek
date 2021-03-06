package com.example.a5215100023.projectkp;

import android.content.Context;
import android.content.SharedPreferences;

public class User {
    Context context;

    public void removeUser(){
        sharedPreferences.edit().clear().commit();
    }

    public String getName() {
        name = sharedPreferences.getString("userdata","");
        return name;
    }

    public void setName(String name) {
        this.name = name;
        sharedPreferences.edit().putString("userdata",name).commit();
    }

    public String getToilet() {
        toilet = sharedPreferences.getString("toilet","");
        return toilet;
    }

    public void setToilet(String toilet) {
        this.toilet = toilet;
        sharedPreferences.edit().putString("toilet",toilet).commit();
    }

    public String getId_absensi() {
        id_absensi = sharedPreferences.getString("id_absensi","");
        return id_absensi;
    }

    public void setId_absensi(String id_absensi) {
        this.id_absensi = id_absensi;
        sharedPreferences.edit().putString("id_absensi",id_absensi).commit();
    }

    public String getNama_alat() {
        nama_alat = sharedPreferences.getString("nama_alat","");
        return nama_alat;
    }

    public void setNama_alat(String nama_alat) {
        this.nama_alat = nama_alat;
        sharedPreferences.edit().putString("nama_alat",nama_alat).commit();
    }

    private String name, toilet, id_absensi, nama_alat;
    SharedPreferences sharedPreferences;

    public User(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
    }
}
