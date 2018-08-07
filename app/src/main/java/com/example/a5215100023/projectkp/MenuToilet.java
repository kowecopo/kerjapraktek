package com.example.a5215100023.projectkp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuToilet extends AppCompatActivity {
Button s ;
Button log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_toilet);

        s = (Button) findViewById(R.id.button);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), UploadGambar.class));
            }
        }

        );
    }

    @Override
    public void onBackPressed() { }

    public void LogOut(View view){
        new User(MenuToilet.this).removeUser();
        Intent i = new Intent(MenuToilet.this, Barcode.class);
        startActivity(i);
        finish();
    }
}
