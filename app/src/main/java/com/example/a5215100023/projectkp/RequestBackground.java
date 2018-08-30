package com.example.a5215100023.projectkp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class RequestBackground extends AsyncTask<String, Void, String> {
    Context context;
    AlertDialog dialog;
    String nama1, nama2, toilet1, toilet2, jadwal1, jadwal2;
    public RequestBackground(Context ctx){
        context = ctx;
    }

    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String result="";
        String login_url = "http://192.168.56.1/kp/request.php";
        if(type.equals("request")){
            try {
                nama1 = params[1];
                nama2 = params[2];
                toilet1 = params[3];
                toilet2 = params[4];
                jadwal1 = params[5];
                jadwal2 = params[6];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data =
                        URLEncoder.encode("nama1", "UTF-8")+"="+URLEncoder.encode(nama1, "UTF-8")+"&"
                                +URLEncoder.encode("nama2", "UTF-8")+"="+URLEncoder.encode(nama2, "UTF-8")+"&"
                                +URLEncoder.encode("toilet1", "UTF-8")+"="+URLEncoder.encode(toilet1, "UTF-8")+"&"
                                +URLEncoder.encode("toilet2", "UTF-8")+"="+URLEncoder.encode(toilet2, "UTF-8")+"&"
                                +URLEncoder.encode("jadwal1", "UTF-8")+"="+URLEncoder.encode(jadwal1, "UTF-8")+"&"
                                +URLEncoder.encode("jadwal2", "UTF-8")+"="+URLEncoder.encode(jadwal2, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));

                String line="";
                while((line = bufferedReader.readLine())!= null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                result = e.getMessage();
            } catch (IOException e) {
                result = e.getMessage();
            }
            return result;
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        Intent i = new Intent(context, Barcode.class);
        context.startActivity(i);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
