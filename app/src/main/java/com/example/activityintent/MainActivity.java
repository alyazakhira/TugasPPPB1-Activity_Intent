package com.example.activityintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText menuEdit;
    Button buttonMakanan;
    Button buttonMinuman;
    TextView jumlahContent;

    public static final String MENU_EXTRA = "TOTAL_KEY";
    public static final String TYPE_EXTRA = "TYPE_KEY";

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK) {
                    String jumlah = result.getData().getStringExtra(SecondActivity.TOTAL_REPLY_EXTRA);
                    jumlahContent.setText(jumlah);
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonMakanan = findViewById(R.id.button_makanan);
        buttonMinuman = findViewById(R.id.button_minuman);
        menuEdit = findViewById(R.id.menu_edit);
        jumlahContent = findViewById(R.id.jumlah_content1);

        buttonMakanan.setOnClickListener(view -> {
            Intent it1 = new Intent(view.getContext(), SecondActivity.class);
            it1.putExtra(MENU_EXTRA, menuEdit.getText().toString());
            it1.putExtra(TYPE_EXTRA, buttonMakanan.getText().toString());
            launcher.launch(it1);
        });

        buttonMinuman.setOnClickListener(view -> {
            Intent it2 = new Intent(view.getContext(), SecondActivity.class);
            it2.putExtra(MENU_EXTRA, menuEdit.getText().toString());
            it2.putExtra(TYPE_EXTRA, buttonMinuman.getText().toString());
            launcher.launch(it2);
        });


    }
}