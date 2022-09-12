package com.example.activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView detailJenis;
    TextView detailMenu;
    EditText jumlahContent;
    Button buttonOK;

    public static final String TOTAL_REPLY_EXTRA = "TOTAL_REPLY_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        detailJenis = findViewById(R.id.detail_jenis);
        detailMenu = findViewById(R.id.detail_menu);
        jumlahContent = findViewById(R.id.jumlahcontent2);
        buttonOK = findViewById(R.id.button_ok);

        Bundle bundle = getIntent().getExtras();
        String menu = bundle.getString(MainActivity.MENU_EXTRA);
        String jenis = bundle.getString(MainActivity.TYPE_EXTRA);
        detailJenis.setText(jenis);
        detailMenu.setText(menu);

        buttonOK.setOnClickListener(view -> {
            Intent it = new Intent(view.getContext(), MainActivity.class);
            it.putExtra(TOTAL_REPLY_EXTRA, jumlahContent.getText().toString());
            setResult(RESULT_OK, it);
            finish();
        });
    }
}