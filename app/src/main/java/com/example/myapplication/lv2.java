package com.example.myapplication;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class lv2 extends AppCompatActivity {
    public TextView c1, c2, c3, c4, a1, a2, a3, a4, textView, check;
    Display display;
    Point size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lv2);
    }

}
