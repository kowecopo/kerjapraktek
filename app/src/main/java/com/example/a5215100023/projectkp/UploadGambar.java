package com.example.a5215100023.projectkp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class UploadGambar extends AppCompatActivity {

    Button btnPilih1, btnPilih2, btnUpload;
    ImageView iv1, iv2;
    final int CODE_GALLERY_REQUEST

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_gambar);

        btnPilih1 = (Button) findViewById(R.id.button3);
        iv1 = (ImageView) findViewById(R.id.imageView);
        btnUpload = (Button) findViewById(R.id.button12);
    }
}
