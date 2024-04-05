package com.example.ltdd_b3;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivityBT1 extends AppCompatActivity {

    private int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3}; // Danh sách ID hình ảnh
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bt1);

        imageView = findViewById(R.id.imageView);

        // Tự động thay đổi hình nền sau mỗi 5 giây
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    imageView.setImageResource(images[new Random().nextInt(images.length)]);
                });
            }
        }, 0, 3000); // 5000 milliseconds = 5 seconds
    }
}