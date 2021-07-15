package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText num1,num2,result;
    Button plu,min,mul,div;
    double a,b,c=0;
    View.OnClickListener cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1=(EditText)findViewById(R.id.num1);
        num2=(EditText)findViewById(R.id.num2);
        result=(EditText)findViewById(R.id.result);
        plu=(Button)findViewById(R.id.plu);
        min=(Button)findViewById(R.id.min);
        mul=(Button)findViewById(R.id.mul);
        div=(Button)findViewById(R.id.div);

        cl=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a=Double.parseDouble(num1.getText().toString());
                b=Double.parseDouble(num2.getText().toString());

                switch (v.getId()){
                    case R.id.plu:
                        c=a+b;
                        break;
                    case R.id.min:
                        c=a-b;
                        break;
                    case R.id.mul:
                        c=a*b;
                        break;
                    case R.id.div:
                        if(b==0) {
                            Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다", Toast.LENGTH_LONG).show();
                        }
                        else{
                            c=a/b;
                            break;
                        }
                }
                result.setText(String.valueOf(c));
            }
        };
        plu.setOnClickListener(cl);
        min.setOnClickListener(cl);
        mul.setOnClickListener(cl);
        div.setOnClickListener(cl);
    }
}