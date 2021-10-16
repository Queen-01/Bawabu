package com.queen.bawabu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.queen.bawabu.R;

public class CheckIn extends AppCompatActivity {

    ImageView imageView;
    Button mReg;
    EditText mName, mPlate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        imageView = findViewById(R.id.image);
        mReg = findViewById(R.id.reg);

        mReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckIn.this, Register.class);
                startActivity(intent);
            }
        });

//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(CheckIn.this, Fingerprint.class);
//                startActivity(intent);
//            }
//        });
    }
}