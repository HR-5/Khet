package com.example.khet.Canvas;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import com.example.khet.R;


public class MyCanvas extends View {
   
    Bitmap bit;
    Canvas mcan;
    Paint border,p1,p2;
    int black,red,blue;
    int[] xc,yc;
    int sw,sh,lenght,startx,starty,endx,endy;


    public MyCanvas(Context context) {
        this(context, null);
    }

    public MyCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        black = ResourcesCompat.getColor(getResources(), R.color.colorPrimaryDark, null);
        red = ResourcesCompat.getColor(getResources(), R.color.toolbar, null);
        blue = ResourcesCompat.getColor(getResources(), R.color.blue, null);
        border = new Paint();
        p1 = new Paint();
        p2 = new Paint();
        xc = new int[11];
        yc = new int[11];
        DisplayMetrics displayMetrics = new DisplayMetrics();

        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);


        sw = displayMetrics.widthPixels;
        sh = displayMetrics.heightPixels;
        int y = ((sh - sw + 100) / 2) - 50;
        starty = y;
        startx = 50;
        endx = sw - 50;
        int w = (sw - 100);
        lenght = (endx - startx)/10;
        endy = starty+lenght*10;
        layout(0, sw, y, y + w + 50);
        border.setColor(black);
        border.setAntiAlias(true);
        border.setStyle(Paint.Style.STROKE);
        border.setStrokeJoin(Paint.Join.ROUND);
        border.setStrokeCap(Paint.Cap.ROUND);
        border.setStrokeWidth(10);
        border.setStyle(Paint.Style.STROKE);
        setPaint(p1, red, 10, 50);
        setPaint(p2, red, 10, 50);
        getCor();
    }

    private void getCor(){
        for (int i = 0; i < 11; i++) {
            xc[i] = startx+i*lenght;
            yc[i]  = starty+i*lenght;
        }
    }

    private void setPaint(Paint paint, int color, double stroke, int size) {
        paint.setColor(color);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setTextSize(size);
        paint.setStrokeWidth((float) stroke);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bit = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mcan = new Canvas(bit);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (bit != null)
            canvas.drawBitmap(bit, 0, 0, null);
        drawbor();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float px = event.getX();
        float py = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

        }
        invalidate();
        return true;
    }

    private void drawbor(){
        for (int i = 0; i < 11; i++) {
            mcan.drawLine(startx,starty+i*lenght,endx,starty+i*lenght,border);
            mcan.drawLine(startx+i*lenght,starty,startx+i*lenght,endy,border);
        }
    }
}

