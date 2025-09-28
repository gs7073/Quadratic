package com.example.quadratic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    ImageView parabula;
    TextView tvSolve;
    String res;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main2);

        parabula = findViewById(R.id.parabula);
        tvSolve = findViewById(R.id.tvSolve);

        double a = getIntent().getDoubleExtra("aa", 0);
        double b1 = getIntent().getDoubleExtra("bb", 0);
        double c = getIntent().getDoubleExtra("cc", 0);

        res = solve(a, b1, c);
        tvSolve.setText(res);
    }

    public String solve(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                if (c == 0) return "all solutionsm";
                else return "no solution";
            } else {
                double x = -c / b;
                return "x=" + x;
            }
        }
        double d = b*b - 4*a*c;
        if (d < 0) {
            return "no roots";
        } else if (d == 0) {
            double x = -b / (2*a);
            return "x=" + x;
        } else {
            double s = Math.sqrt(d);
            double x1 = (-b + s) / (2*a);
            double x2 = (-b - s) / (2*a);
            return "x1=" + x1 + " x2=" + x2;
        }
    }

    public void back1(View v) {
        Intent i = new Intent();
        i.putExtra("answer: ", res);
        setResult(RESULT_OK, i);
        finish();
    }
}
