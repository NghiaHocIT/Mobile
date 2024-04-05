package com.example.ltdd_b1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

public class Bai3Activity extends AppCompatActivity {

    EditText editTextArray;
    TextView result;
    Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        anhXa();

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String editTextContent = editTextArray.getText().toString();
                String[] numberStrings = editTextContent.split(" "); // Giả sử số được phân tách bằng dấu cách
                ArrayList<Integer> numbers = new ArrayList<>();
                StringBuilder primeNumbers = new StringBuilder();
                boolean hasPrimeNumbers = false;

                for (String numberString : numberStrings) {
                    try {
                        int number = Integer.parseInt(numberString);
                        numbers.add(number);
                    } catch (NumberFormatException e) {
                        Log.d("Number Conversion", "Không thể chuyển đổi " + numberString + " thành số nguyên.");
                    }
                }

                for (int number : numbers) {
                    if (isPrime(number)) {
                        primeNumbers.append(number).append(" ");
                        hasPrimeNumbers = true;
                    }
                }

                if (hasPrimeNumbers) {
                    result.setText("Số nguyên tố: " + primeNumbers.toString());
                } else {
                    result.setText("Không có số nguyên tố.");
                }
            }
        });
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public void anhXa(){
        editTextArray = (EditText) findViewById(R.id.editTextArray);
        result = (TextView) findViewById(R.id.result);
        btnResult = (Button) findViewById(R.id.btnResult);
    }
}