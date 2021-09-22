package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public String temp;
    private EditText textinput2;
    private Spinner spinner;
    private Spinner spinner2;
    private Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         textinput2 = (EditText) findViewById(R.id.editTextNumber);
        switch1 = (Switch) findViewById(R.id.switch1);

        textinput2.setOnKeyListener(new View.OnKeyListener(){
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                //final Switch switch1 = (Switch) findViewById(R.id.switch1);
                if(switch1.isChecked()) {
                    Log.d("main.activity", "onKey");
                    calcultemp();
                }
                return false;
            }

        });
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("mainactivity", "onItemselected");
                if(switch1.isChecked()) {
                    calcultemp();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
               // calcultemp();
                Log.d("mainactivity", "onItemselected1noselected");

            }
        });
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("mainactivity", "onItemselected2");
                if(switch1.isChecked()) {
                    calcultemp();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                Log.d("mainactivity", "onItemselected2noselected");
            }
        });
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.d("mainactivity", "switchcheck");
                calcultemp();
            }
        });


   }








    public void calcultemp(){
        //final Switch switch1 = (Switch) findViewById(R.id.switch1);
        //Log.d("salsultemp","un");
        textinput2 = (EditText) findViewById(R.id.editTextNumber);
        String temp = getString(R.string.input_number_enter);
         spinner = (Spinner) findViewById(R.id.spinner);
         spinner2 = (Spinner) findViewById(R.id.spinner2);
        //final EditText Textinput = (EditText) findViewById(R.id.editTextNumber);

            //String temp = getString(R.string.input_number_enter);
            //System.out.println(temp);

            String temperature1="";
            temperature1= spinner.getSelectedItem().toString();

            String temperature2="";
            temperature2= spinner2.getSelectedItem().toString();


            Editable n =textinput2.getText();
            String ninput = n.toString();
            Double fn = 0.0;

            if (temperature1.equals("°C") && temperature2.equals("°F")) {
                Double nb = Double.parseDouble(ninput);

                fn = nb * 9 / 5 + 32;
            }

            if (temperature1.equals("°F") && temperature2.equals("°C")) {
                Double nb = Double.parseDouble(ninput);
                fn = ((nb - 32) * 5 / 9);

            }
            if (temperature1.equals("°F") && temperature2.equals("°K")) {
                Double nb = Double.parseDouble(ninput);
                fn = (nb + 459.67) / 1.8;

            }
            if (temperature1.equals("°K") && temperature2.equals("°F")) {
                Double nb = Double.parseDouble(ninput);
                fn = nb * 1.8 - 459.67;

            }
            if (temperature1.equals("°C") && temperature2.equals("°K")) {
                Double nb = Double.parseDouble(ninput);
                fn = nb + 273.15;

            }
            if (temperature1.equals("°K") && temperature2.equals("°C")) {
                Double nb = Double.parseDouble(ninput);
                fn = nb - 273.15;

            }
        if (temperature1.equals("°K") && temperature2.equals("°K")) {
            Double nb = Double.parseDouble(ninput);
            fn = nb;

        }
        if (temperature1.equals("°C") && temperature2.equals("°C")) {
            Double nb = Double.parseDouble(ninput);
            fn = nb;

        }
        if (temperature1.equals("°F") && temperature2.equals("°F")) {
            Double nb = Double.parseDouble(ninput);
            fn = nb ;

        }
          final TextView helloTextView = (TextView) findViewById(R.id.textView4);
           // Double = Double.parseDouble(helloTextView);
           String nbfn = String.valueOf(fn);
            helloTextView.setText(nbfn);

     }



    public void editTemp(View view) {
      //  final Switch switch1 = (Switch) findViewById(R.id.switch1);
        if(switch1.isChecked()){
            Log.d("mainactivity","do nothing");
        }
        else {
            calcultemp();
        }
    }



}