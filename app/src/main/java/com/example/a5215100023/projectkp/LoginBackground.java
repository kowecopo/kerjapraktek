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

public class LoginBackground extends AsyncTask<String, Void, String> {
    Context context;
    AlertDialog dialog;
    String username;
    public LoginBackground(Context ctx){
        context = ctx;
    }

    @Override
    protected void onPreExecute() {
//        dialog = new AlertDialog.Builder(context).create();
//        dialog.setTitle("Login Status");
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String result="";
        String login_url = "http://192.168.56.1/kp/login.php";
        if(type.equals("login")){
            try {
                username = params[1];
                String password = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("username", "UTF-8")+"="+URLEncoder.encode(username, "UTF-8")+"&"
                        +URLEncoder.encode("password", "UTF-8")+"="+URLEncoder.encode(password, "UTF-8");
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
//                e.printStackTrace();
            } catch (IOException e) {
//                e.printStackTrace();
                result = e.getMessage();
            }
            return result;
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
//        dialog.setMessage(result);
//        dialog.show();
        if(result.equals("login failed")){
            Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
            User user = new User(this.context);
            user.setName(username);
            Intent i = new Intent(context, MenuToilet.class);
            context.startActivity(i);

//            alertDialog.setMessage(result);
//            alertDialog.show();
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
