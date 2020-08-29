package com.example.khet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.khet.Canvas.MyCanvas;

public class MainActivity extends AppCompatActivity {

    Button up, down, left, right,ul,ur,dl,dr,rc,ra;
    MyCanvas myCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.cons);
        myCanvas = new MyCanvas(this);
        set();
        constraintLayout.addView(myCanvas);
    }

    public void set(){
        up = (Button) findViewById(R.id.up);
        down = (Button) findViewById(R.id.down);
        left = (Button) findViewById(R.id.left);
        right = (Button) findViewById(R.id.right);
        ul = (Button) findViewById(R.id.ul);
        ur = (Button) findViewById(R.id.ur);
        dl = (Button) findViewById(R.id.dl);
        dr = (Button) findViewById(R.id.dr);
        ra = (Button) findViewById(R.id.ra);
        rc = (Button) findViewById(R.id.rc);
        setOnclick();
    }
    public void setOnclick(){
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCanvas.upmove();
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCanvas.downmove();
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCanvas.leftmove();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCanvas.rightmove();
            }
        });
        ul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCanvas.ulmove();
            }
        });
        ur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCanvas.urmove();
            }
        });
        dr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCanvas.drmove();
            }
        });
        dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCanvas.dlmove();
            }
        });
        rc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCanvas.rcmove();
            }
        });
        ra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myCanvas.ramove();
            }
        });
    }
}
