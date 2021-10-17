package com.queen.bawabu.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.queen.bawabu.R;

public class CheckIn extends AppCompatActivity {

    ImageView imageView;
    TextView mReg;
    Button mCheck;
    EditText Name, Plate;
    TextInputEditText Text;
    Intent intent;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        imageView = findViewById(R.id.image);
        mReg = findViewById(R.id.reg);
        mCheck = findViewById(R.id.check);
        Name = findViewById(R.id.Name);
        Plate = findViewById(R.id.plate);
        Text =findViewById(R.id.input);

        sharedPreferences = getSharedPreferences("Details", MODE_PRIVATE);
        intent = new Intent(CheckIn.this, Success.class);
        if (sharedPreferences.contains("Name") && sharedPreferences.contains("Plate") && sharedPreferences.contains("Text")) {
            startActivity(intent);
        }

        mCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = CheckIn.this.Name.getText().toString();
                String Plate = CheckIn.this.Plate.getText().toString();
                String Text = CheckIn.this.Text.getText().toString();

                if (Name.equals("Quienzy Ong'eye") && Plate.equals("KDA 736K") && Text.equals("Business Transactions")) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    editor.putString("Name", Name);
                    editor.putString("Plate", Plate);
                    editor.putString("Text", Text);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "You are Checked In", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "EnterRight Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

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