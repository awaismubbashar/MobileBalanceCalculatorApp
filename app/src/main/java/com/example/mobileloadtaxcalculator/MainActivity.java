package com.example.mobileloadtaxcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText enterText;
    private TextView showText;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterText = (EditText) findViewById(R.id.enterText);
        showText = (TextView) findViewById(R.id.showText);
        btn = (Button) findViewById(R.id.convertToLoadBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enterText.getText().toString().equals("")){
                    enterText.setError("Please Enter Load Balance in Box");
                    showText.setVisibility(View.VISIBLE);
                }
                else {
                    int getLoadNum = Integer.valueOf(enterText.getText().toString());
                    float tax = (float) (getLoadNum*(11.12/100));
                    float originalLoad = getLoadNum -tax;

                    showText.setText(String.valueOf(originalLoad));
                    showText.setVisibility(View.VISIBLE);
                }

            }
        });
    }
}