package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Switch switch1=(Switch) findViewById(R.id.switch1);
    //Boolean rep=switch1.idChecked();

   // if(switch1.)
    public void editTemp(View view) {
        String test="toto";
        String temp = getString(R.string.input_number_enter);
        System.out.println(temp);
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        String temperature1 = spinner.getSelectedItem().toString();
        Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        String temperature2 = spinner2.getSelectedItem().toString();

        final EditText Textinput = (EditText) findViewById(R.id.editTextNumber);
        Editable n = Textinput.getText();
        String ninput= n.toString();
        Double fn=0.0;

        if(temperature1.equals("°C") && temperature2.equals("°F"))
        {
            Double nb=Double.parseDouble(ninput);

            fn =  nb*9/5 + 32;
        }

        if(temperature1.equals("°F") && temperature2.equals("°C"))
        {
            Double nb=Double.parseDouble(ninput);
            fn =  (( nb - 32)*5/9);

        }
        if(temperature1.equals("°F") && temperature2.equals("°K"))
        {
            Double nb=Double.parseDouble(ninput);
            fn =  (nb + 459.67)/1.8;

        }
        if(temperature1.equals("°K") && temperature2.equals("°F"))
        {
            Double nb=Double.parseDouble(ninput);
            fn = nb* 1.8-459.67;

        }
        if(temperature1.equals("°C") && temperature2.equals("°K"))
        {
            Double nb=Double.parseDouble(ninput);
            fn = nb + 273.15;

        }
        if(temperature1.equals("°K") && temperature2.equals("°C"))
        {
            Double nb=Double.parseDouble(ninput);
            fn = nb - 273.15;

        }
        final TextView helloTextView = (TextView) findViewById(R.id.textView4);
        // Double = Double.parseDouble(helloTextView);
        String nbfn = String.valueOf(fn);
        helloTextView.setText(nbfn);

    }
}