package com.example.ltdd_b3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity4 extends AppCompatActivity {

    private void handleMenuItemClick(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuSetting) {
            // Xử lý khi người dùng chọn "Setting"
        } else if (id == R.id.menuShare) {
            // Xử lý khi người dùng chọn "Share"
        } else if (id == R.id.menuLogout) {
            // Xử lý khi người dùng chọn "Logout"
        }
    }
    private void showMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu_setting, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                handleMenuItemClick(item);
                return true;
            }
        });
        popupMenu.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Button btnShowMenu = findViewById(R.id.btnShowMenu);
        btnShowMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });

        Button btnPopMenu = findViewById(R.id.btnPopMenu);
        btnPopMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });

        Button btnButton = findViewById(R.id.btnButton);

        registerForContextMenu(btnButton);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting,menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.getMenuInflater().inflate(R.menu.menu_setting, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.menuSetting) {
                    // Xử lý khi người dùng chọn "Setting"
                } else if (id == R.id.menuShare) {
                    // Xử lý khi người dùng chọn "Share"
                    Button btnPopMenu = findViewById(R.id.btnPopMenu);
                    btnPopMenu.setText("Chia sẻ");
                } else if (id == R.id.menuLogout) {
                    // Xử lý khi người dùng chọn "Logout"
                }

                return true;
            }
        });

        popupMenu.show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        menu.setHeaderTitle("Context Menu");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuSetting) {
            // Xử lý khi người dùng chọn "Setting"
            Toast.makeText(MainActivity4.this, "Bạn đang chọn Setting", Toast.LENGTH_LONG).show();
            return true;
        } else if (id == R.id.menuShare) {
            // Xử lý khi người dùng chọn "Share"
            Button btnButton = findViewById(R.id.btnButton);
            if (btnButton != null) {
                btnButton.setText("Chia sẻ");
            }
            return true;
        } else if (id == R.id.menuLogout) {
            // Xử lý khi người dùng chọn "Logout"
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }

}