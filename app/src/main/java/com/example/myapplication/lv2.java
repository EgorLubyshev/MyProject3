package com.example.myapplication;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class lv2 extends AppCompatActivity {
    public TextView c1, c2, c3, a1, a2, a3, textView, check;
    Display display;
    Point size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lv2);

        textView = findViewById(R.id.text_view1);
        check = findViewById(R.id.check);

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);

        a1 = findViewById(R.id.answer1);
        a2 = findViewById(R.id.answer2);
        a3 = findViewById(R.id.answer3);

        display = getWindowManager().getDefaultDisplay();
        size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        a1.setHeight(height / 9);
        a2.setHeight(height / 9);
        a3.setHeight(height / 9);
        a1.setWidth(width / 3);
        a2.setWidth(width / 3);
        a3.setWidth(width / 3);


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c(c1);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c(c2);
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c(c3);
            }
        });
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans(a1);
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans(a2);
            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans(a3);
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();
            }
        });

    }

    void c(TextView c) {
        if (a1.getText().equals("")) {
            a1.setText(c.getText());
            c.setVisibility(View.INVISIBLE);
        } else {
            if (a2.getText().equals("")) {
                a2.setText(c.getText());
                c.setVisibility(View.INVISIBLE);
            } else {
                if (a3.getText().equals("")) {
                    a3.setText(c.getText());
                    c.setVisibility(View.INVISIBLE);
                }
            }
        }
    }

    void ans(TextView answer) {
        if (answer.getText().equals(c1.getText())) {
            c1.setVisibility(View.VISIBLE);
            answer.setText("");
        }
        if (answer.getText().equals(c2.getText())) {
            c2.setVisibility(View.VISIBLE);
            answer.setText("");
        }
        if (answer.getText().equals(c3.getText())) {
            c3.setVisibility(View.VISIBLE);
            answer.setText("");
        }

    }

    void check() {
        if ((a1.getText().equals("a=3") || a1.getText().equals("b=2") )&& (a2.getText().equals("a=3") ||
                a2.getText().equals("b=2")) &&
                a3.getText().equals("print(a+b)")) {
            Toast.makeText(this, "все верно!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), lv2.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Ошибка!", Toast.LENGTH_SHORT).show();
        }
    }
}
