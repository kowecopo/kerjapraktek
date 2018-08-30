package com.example.a5215100023.projectkp;

import android.app.DatePickerDialog;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class GantiJadwal extends AppCompatActivity{

    EditText etNama1, etNama2, etToilet1, etToilet2, etJadwal1, etJadwal2;
    DatePickerDialog datePickerDialog, datePickerDialog1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganti_jadwal);
        etNama1 = findViewById(R.id.etNama1);
        etNama2 = findViewById(R.id.etNama2);
        etToilet1 = findViewById(R.id.etToilet1);
        etToilet2 = findViewById(R.id.etToilet2);
        etJadwal1 = findViewById(R.id.jadwal1);
        etJadwal2 = findViewById(R.id.jadwal2);

        etJadwal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(GantiJadwal.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        etJadwal1.setText(year+"-"+(month+1)+"-"+day);
                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        etJadwal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                final int yearr = cal.get(Calendar.YEAR);
                final int monthh = cal.get(Calendar.MONTH);
                final int dayy = cal.get(Calendar.DAY_OF_MONTH);
                datePickerDialog1 = new DatePickerDialog(GantiJadwal.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int yearr, int monthh, int dayy) {
                        etJadwal2.setText(yearr+"-"+(monthh+1)+"-"+dayy);
                    }
                },yearr,monthh,dayy);
                datePickerDialog1.show();
            }
        });
    }

    public void SendReq(View view) {
        String nama1 = etNama1.getText().toString();
        String nama2 = etNama2.getText().toString();
        String toilet1 = etToilet1.getText().toString();
        String toilet2 = etToilet2.getText().toString();
        String jadwal1 = etJadwal1.getText().toString();
        String jadwal2 = etJadwal2.getText().toString();
        String type = "request";
        RequestBackground requestBackground = new RequestBackground(this);
        requestBackground.execute(type, nama1, nama2, toilet1, toilet2, jadwal1, jadwal2);
    }

}
