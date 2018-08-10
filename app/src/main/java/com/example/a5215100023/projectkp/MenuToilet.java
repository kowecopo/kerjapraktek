package com.example.a5215100023.projectkp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuToilet extends AppCompatActivity {
Button btnCermin, btnUrinoir, btnCloset, btnWastafel, btnLantai, btnPintu, btnKaca;
Button log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_toilet);
        btnCermin = (Button) findViewById(R.id.button);
        btnUrinoir = (Button) findViewById(R.id.buttonUrinoir);
        btnCloset = (Button) findViewById(R.id.buttonCloset);
        btnWastafel = (Button) findViewById(R.id.buttonWastafel);
        btnLantai = (Button) findViewById(R.id.buttonLantai);
        btnPintu = (Button) findViewById(R.id.buttonPintu);
        btnKaca = (Button) findViewById(R.id.buttonKaca);

        btnCermin.setOnClickListener(new View.OnClickListener() {
            final User user = new User(MenuToilet.this);
            @Override
            public void onClick(View view) {
                user.setNama_alat("Cermin");
                startActivity(new Intent(getApplicationContext(), UploadGambar.class));
            }
        });

        btnUrinoir.setOnClickListener(new View.OnClickListener() {
            final User user = new User(MenuToilet.this);
            @Override
            public void onClick(View view) {
                user.setNama_alat("Urinoir");
                startActivity(new Intent(getApplicationContext(), UploadGambar.class));
            }
        });

        btnKaca.setOnClickListener(new View.OnClickListener() {
            final User user = new User(MenuToilet.this);
            @Override
            public void onClick(View view) {
                user.setNama_alat("Kaca");
                startActivity(new Intent(getApplicationContext(), UploadGambar.class));
            }
        });

        btnPintu.setOnClickListener(new View.OnClickListener() {
            final User user = new User(MenuToilet.this);
            @Override
            public void onClick(View view) {
                user.setNama_alat("Pintu");
                startActivity(new Intent(getApplicationContext(), UploadGambar.class));
            }
        });

        btnLantai.setOnClickListener(new View.OnClickListener() {
            final User user = new User(MenuToilet.this);
            @Override
            public void onClick(View view) {
                user.setNama_alat("Lantai");
                startActivity(new Intent(getApplicationContext(), UploadGambar.class));
            }
        });

        btnWastafel.setOnClickListener(new View.OnClickListener() {
            final User user = new User(MenuToilet.this);
            @Override
            public void onClick(View view) {
                user.setNama_alat("Wastafel");
                startActivity(new Intent(getApplicationContext(), UploadGambar.class));
            }
        });

        btnCloset.setOnClickListener(new View.OnClickListener() {
            final User user = new User(MenuToilet.this);
            @Override
            public void onClick(View view) {
                user.setNama_alat("Closet");
                startActivity(new Intent(getApplicationContext(), UploadGambar.class));
            }
        });

    }

    @Override
    public void onBackPressed() { }

    public void LogOut(View view){

        String type = "logout";
        final User user = new User(MenuToilet.this);
        String id_absensi = user.getId_absensi();
        LogoutBackground logoutBackground = new LogoutBackground(this);
        logoutBackground.execute(type,id_absensi);

        new User(MenuToilet.this).removeUser();
        Intent i = new Intent(MenuToilet.this, Barcode.class);
        startActivity(i);
        finish();
    }
}
