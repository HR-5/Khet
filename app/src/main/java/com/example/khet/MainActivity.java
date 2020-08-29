package com.example.khet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;

import com.example.khet.Canvas.MyCanvas;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.cons);
        MyCanvas myCanvas = new MyCanvas(this);
        constraintLayout.addView(myCanvas);
    }
}
