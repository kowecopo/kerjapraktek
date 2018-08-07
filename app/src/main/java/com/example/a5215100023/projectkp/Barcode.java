package com.example.a5215100023.projectkp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Barcode extends AppCompatActivity {

    Button scan_btn;
    Spinner sp;
    TextView display_data;
 //   TextView display_data2;
    String names[] = {" ", "Toilet 1", "Toilet 2", "Toilet 3", "Toilet 4"};
    ArrayAdapter<String> adapter;
    String record = "";
 //   Connectionclass connectionclass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);

//barcode
        scan_btn = (Button)findViewById(R.id.scan_btn);
        final Activity activity = this;
        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });

//spinner
        sp = (Spinner) findViewById(R.id.spinner);
      //  String text = sp.getSelectedItem().toString();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        display_data = (TextView) findViewById(R.id.display_result);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        record = " ";
                        break;
                    case 1:
                        record = "Toilet 1";
                        break;
                    case 2:
                        record = "Toilet 2";
                        break;
                    case 3:
                        record = "Toilet 3";
                        break;
                    case 4:
                        record = "Toilet 4";
                        break;
                }
            }


            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void diplsyResult (View view) {
        display_data.setTextSize(18);
        display_data.setText(record);

    }

            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
     //         String display = display_data.getText().toString();
      //          String resultt = result.getContents().toString();
                if (result != null) {
                    if (result == null) {
                        Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Barcode.this, Login.class);
                        startActivity(intent);
             //       } else {
                //        super.onActivityResult(requestCode, resultCode, data);
                  //      Toast.makeText(this, "Barcode salah", Toast.LENGTH_LONG).show();

                    }
                }
            }



    }

