package com.queen.bawabu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.queen.bawabu.R;

public class Success extends AppCompatActivity {
    SharedPreferences newPreference;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        TextView result = findViewById(R.id.info_text);
        Button Chkout = findViewById(R.id.LogOut);

        newPreference = getSharedPreferences("user_details", MODE_PRIVATE);
        intent =new Intent(Success.this, CheckIn.class);
        result.setText("Welcome" + newPreference.getString("Name", null));

        Chkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = newPreference.edit();
                edit.clear();
                edit.commit();
                startActivity(intent);
            }
        });
    }
}