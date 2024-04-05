package com.example.ltdd_b1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView txtHoten;
    TextView txtNoiDung1;
    Button btnDangnhap;
    EditText editTextname;
    EditText editTextpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title not the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//int flag, int mask
        setContentView(R.layout.activity_main);

        txtHoten = (TextView) findViewById(R.id.texthoten);
        txtHoten.setText("Lê Quang Trọng Nghĩa");
        txtHoten.setTextColor(getResources().getColor(R.color.red));


        btnDangnhap =(Button) findViewById(R.id.btnDangNhap);
        editTextname = (EditText) findViewById(R.id.editTextName);
        editTextpass = (EditText) findViewById(R.id.editTextPassword);
        txtNoiDung1 = (TextView) findViewById(R.id.editTxtNoiDung1);

        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//viết code
                if(editTextname.getText().toString().equals("nghia")
                        && editTextpass.getText().toString().equals("nghia")){
                    txtNoiDung1.setText("Đăng nhập thành công!");
                }else{
                    txtNoiDung1.setText("Đăng nhập thất bại!");
                }
            }
        });
    }
}