package com.example.ltdd_b1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Bai4Activity extends AppCompatActivity {

    private EditText editText;
    private Button generateButton;
    private TextView textView;
    private Button checkButton;

    private List<Integer> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);

        editText = findViewById(R.id.editText);
        generateButton = findViewById(R.id.generateButton);
        textView = findViewById(R.id.textView);
        checkButton = findViewById(R.id.checkButton);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumbers();
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPerfectSquares();
            }
        });
    }

    private void generateRandomNumbers() {
        String input = editText.getText().toString();
        int count = Integer.parseInt(input);

        numbers = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int number = random.nextInt(101); // Sinh số ngẫu nhiên từ 0 đến 100
            numbers.add(number);
        }

        displayNumbers();
    }

    private void displayNumbers() {
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number).append(", ");
        }
        String numbersString = sb.toString();
        if (numbersString.length() > 2) {
            numbersString = numbersString.substring(0, numbersString.length() - 2);
        }
        textView.setText(numbersString);
    }

    private void checkPerfectSquares() {
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            if (isPerfectSquare(number)) {
                sb.append(number).append(", ");
            }
        }
        String perfectSquares = sb.toString();
        if (perfectSquares.isEmpty()) {
            perfectSquares = "Không có số chính phương";
        } else {
            perfectSquares = "Số chính phương: " + perfectSquares.substring(0, perfectSquares.length() - 2);
        }
        Toast.makeText(this, perfectSquares, Toast.LENGTH_SHORT).show();
    }

    private boolean isPerfectSquare(int number) {
        double sqrt = Math.sqrt(number);
        return sqrt == (int) sqrt;
    }
}