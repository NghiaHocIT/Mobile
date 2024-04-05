package com.example.ltdd_b3;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Switch;
import android.os.Bundle;
import android.widget.CompoundButton;

public class MainActivityBT2 extends AppCompatActivity {

    private ImageView backgroundImageView;
    private Switch switchBackground;
    private boolean isSwitchEnabled = true;
    private int lightImage = R.drawable.image2; // ID resource hình ảnh chế độ sáng
    private int darkImage = R.drawable.image3; // ID resource hình ảnh chế độ tối
    private ImageView imageView;
    private Switch darkModeSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bt2);

        imageView = findViewById(R.id.imageView);
        darkModeSwitch = findViewById(R.id.switch1);

        // Kiểm tra trạng thái ban đầu của Switch và hiển thị hình nền phù hợp
        if (darkModeSwitch.isChecked()) {
            imageView.setImageResource(darkImage);
        } else {
            imageView.setImageResource(lightImage);
        }

        // Thay đổi hình nền khi bấm Switch
        darkModeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    imageView.setImageResource(darkImage);
                } else {
                    imageView.setImageResource(lightImage);
                }
            }
        });
    }
}