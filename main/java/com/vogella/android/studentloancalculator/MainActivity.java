package com.vogella.android.studentloancalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText edittext1, edittext2, edittext3, edittext4;
    private Button buttonCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }

    public void addListenerOnButton() {
        edittext1 = (EditText) findViewById(R.id.editText1);
        edittext2 = (EditText) findViewById(R.id.editText2);
        edittext3 = (EditText) findViewById(R.id.editText3);
        edittext4 = (EditText) findViewById(R.id.editText4);
        buttonCalculate = (Button) findViewById(R.id.button);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String loanAmount=edittext1.getText().toString();
                String interestRate=edittext2.getText().toString();
                String loanTerm=edittext3.getText().toString();
                String loanFees=edittext4.getText().toString();

                int a = Integer.parseInt(loanAmount);
                int b = Integer.parseInt(interestRate);
                int c = Integer.parseInt(loanTerm);
                int d = Integer.parseInt(loanFees);

                int balance = a;
                int months = c * 12;
                int monthlyBalance = (balance / months);
                int interest = (monthlyBalance * b) / 100;
                double monthlyPayment = (monthlyBalance + b);
                double totalInterest = balance - (monthlyPayment*12);

                Toast.makeText(getApplicationContext(),"The monthly payment is " + String.valueOf(monthlyPayment) + "The total interest is " + String.valueOf(totalInterest),Toast.LENGTH_LONG).show();

            }
        });

    }
}