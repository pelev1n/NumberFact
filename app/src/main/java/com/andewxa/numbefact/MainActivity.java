package com.andewxa.numbefact;

import android.os.Build;
import android.os.StrictMode;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity  {

    //  interesting facts about numbers


    TextView resultField; // текстовое поле для вывода результата
    EditText numberField;   // поле для ввода числа
    String url ="http://numbersapi.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        // получаем все поля по id из activity_main.xml
        numberField = (EditText) findViewById(R.id.numberField);
        resultField =(TextView) findViewById(R.id.resultField);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void factClick(View view) throws IOException {

        String searchNumb = numberField.getText().toString();
        String finalUr1 = url+searchNumb;

        GetNumber getNumber = new GetNumber();
        String response = getNumber.run(finalUr1);

        resultField.setText(response.toString());
    }

}
