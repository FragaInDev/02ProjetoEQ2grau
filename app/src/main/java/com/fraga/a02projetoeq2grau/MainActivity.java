/*
*@author:Bruno Fraga
*/
package com.fraga.a02projetoeq2grau;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText inputA, inputB, inputC;
    private TextView resDelta, resX1, resX2, message;
    private Button calcButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        inputA = findViewById(R.id.inputA);
        inputB = findViewById(R.id.inputB);
        inputC = findViewById(R.id.inputC);
        resDelta = findViewById(R.id.resDelta);
        resX1 = findViewById(R.id.resX1);
        resX2 = findViewById(R.id.resX2);
        message = findViewById(R.id.message);
        calcButton = findViewById(R.id.calcButton);

        calcButton.setOnClickListener(v -> {
            calculate();
        });
    }

    private void calculate() {
        Double iA = Double.parseDouble(inputA.getText().toString());
        Double iB = Double.parseDouble(inputB.getText().toString());
        Double iC = Double.parseDouble(inputC.getText().toString());

        if (iA == 0) {
            message.setText("Essa não é uma equação de 2° grau");
            return;
        }

        Double delta = Math.pow(iB, 2) - 4 * iA * iC;

        if (delta < 0) {
            message.setText("Não há raízes reais");
            return;
        }

        Double x1 = (-iB + Math.sqrt(delta)) / (2 * iA);
        Double x2 = (-iB - Math.sqrt(delta)) / (2 * iA);

        resDelta.setText("Delta: " + delta);
        resX1.setText("X1: " + x1);
        resX2.setText("X2: " + x2);
        message.setText("Raízes reais");

    }

}
