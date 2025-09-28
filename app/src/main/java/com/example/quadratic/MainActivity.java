package com.example.quadratic;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3;
    TextView tvAns;
    int REQ = 1;
    Random r = new Random();

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.num1);
        et2 = findViewById(R.id.num2);
        et3 = findViewById(R.id.num3);
        tvAns = findViewById(R.id.tvAns);
    }

    @Override
    protected void onActivityResult(int src, int res, @Nullable Intent data) {
        super.onActivityResult(src, res, data);
        if (src == REQ && res == RESULT_OK && data != null) {
            String txt = data.getStringExtra("answer: ");
            tvAns.setText(txt);
        }
    }

    public void rand(View v) {
        int a = r.nextInt(9) + 1;
        int b = r.nextInt(19) - 9;
        int c = r.nextInt(19) - 9;
        et1.setText("" + a);
        et2.setText("" + b);
        et3.setText("" + c);
    }

    public void calc(View v) {
        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();
        String s3 = et3.getText().toString();

        if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
            tvAns.setText("error");
            return;
        }

        double a = Double.parseDouble(s1);
        double b = Double.parseDouble(s2);
        double c = Double.parseDouble(s3);

        if (a == 0) {
            tvAns.setText("a=0");
            return;
        }

        Intent in = new Intent(this, calculate.class);
        in.putExtra("aa", a);
        in.putExtra("bb", b);
        in.putExtra("cc", c);
        startActivityForResult(in, REQ);
    }
}
