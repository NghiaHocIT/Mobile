package com.example.ltdd_b1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class Bai5Activity extends AppCompatActivity {

    TextView txtSoN;
    Button btnRnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai5);

        //ánh xạ
        txtSoN = (TextView)
                findViewById(R.id.textViewSo);
        btnRnd = (Button)
                findViewById(R.id.buttonRnd);
        //viết code sinh ngẫu nhiên
        btnRnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        //tạo số ngẫu nhiên
                Random random = new Random();
                int number = random.nextInt(1001);
                txtSoN.setText(number + ""); //number + "" ép kiểu
            }
        });

    }

}