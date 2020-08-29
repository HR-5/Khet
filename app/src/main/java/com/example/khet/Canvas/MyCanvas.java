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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import com.example.khet.Items.King;
import com.example.khet.Items.Omirror;
import com.example.khet.Items.Protector;
import com.example.khet.Items.Tmirror;
import com.example.khet.R;

import java.util.ArrayList;


public class MyCanvas extends View {

    int[][] box, redcoin, bluecoin;
    Bitmap bit;
    Canvas mcan;
    Paint border, p1, p2;
    int black, red, blue,white;
    int[] xc, yc;
    public int sw, sh, lenght, startx, starty, endx, endy;
    ArrayList<Omirror> omirrorsB, omirrorsR;
    ArrayList<Tmirror> tmirrorsB, tmirrorsR;
    ArrayList<Protector> protectorsB, protectorsR;
    King kingB, kingR;
    Context context;
    int xCo, yCo;
    boolean redplay,play;

    public MyCanvas(Context context) {
        this(context, null);
    }

    public MyCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        redplay = true;
        xCo = 100;
        yCo = 100;
        play = false;
        black = ResourcesCompat.getColor(getResources(), R.color.colorPrimaryDark, null);
        red = ResourcesCompat.getColor(getResources(), R.color.toolbar, null);
        blue = ResourcesCompat.getColor(getResources(), R.color.blue, null);
        white = ResourcesCompat.getColor(getResources(), R.color.white, null);
        border = new Paint();
        omirrorsB = new ArrayList<>();
        omirrorsR = new ArrayList<>();
        tmirrorsB = new ArrayList<>();
        tmirrorsR = new ArrayList<>();
        protectorsB = new ArrayList<>();
        protectorsR = new ArrayList<>();
        p1 = new Paint();
        p2 = new Paint();
        xc = new int[11];
        yc = new int[9];
        box = new int[10][8];
        redcoin = new int[10][8];
        bluecoin = new int[10][8];
        kingB = new King(1, 0, 0);
        kingR = new King(0, 0, 0);
        setgame();
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
        lenght = (endx - startx) / 10;
        endy = starty + lenght * 8;
        border.setColor(black);
        border.setAntiAlias(true);
        border.setStyle(Paint.Style.STROKE);
        border.setStrokeJoin(Paint.Join.ROUND);
        border.setStrokeCap(Paint.Cap.ROUND);
        border.setStrokeWidth(10);
        border.setStyle(Paint.Style.STROKE);
        setPaint(p1, red, 10, 50);
        setPaint(p2, blue, 10, 50);
        getCor();
        layout(0, starty - 50, sw, endy + 50);
    }

    private void setgame() {
        box[0][3] = 1;
        redcoin[0][3] = 1;
        omirrorsR.add(new Omirror(0, 0, 3, 1));
        box[0][4] = 1;
        redcoin[0][4] = 1;
        omirrorsR.add(new Omirror(0, 0, 4, 2));
        box[2][3] = 1;
        bluecoin[2][3] = 1;
        omirrorsB.add(new Omirror(1, 2, 3, 3));
        box[2][4] = 1;
        bluecoin[2][4] = 1;
        omirrorsB.add(new Omirror(1, 2, 4, 3));
        box[2][1] = 1;
        redcoin[2][1] = 1;
        omirrorsR.add(new Omirror(0, 2, 1, 3));
        box[2][7] = 1;
        bluecoin[2][7] = 1;
        omirrorsB.add(new Omirror(1, 2, 7, 0));
        box[3][2] = 1;
        bluecoin[3][2] = 1;
        omirrorsB.add(new Omirror(1, 3, 2, 3));
        box[3][7] = 3;
        bluecoin[3][7] = 1;
        protectorsB.add(new Protector(1, 3, 7));
        protectorsB.add(new Protector(1, 3, 7));
        box[4][7] = 4;
        bluecoin[4][7] = 1;
        kingB.setPosx(4);
        kingB.setPosy(7);
        box[5][7] = 3;
        bluecoin[5][7] = 1;
        protectorsB.add(new Protector(1, 5, 7));
        protectorsB.add(new Protector(1, 5, 7));
        box[4][0] = 3;
        redcoin[4][0] = 1;
        protectorsR.add(new Protector(0, 4, 0));
        protectorsB.add(new Protector(0, 4, 0));
        box[5][0] = 4;
        redcoin[5][0] = 1;
        kingR.setPosx(5);
        kingR.setPosy(0);
        box[6][0] = 3;
        redcoin[6][0] = 1;
        protectorsR.add(new Protector(0, 6, 0));
        protectorsB.add(new Protector(0, 6, 0));
        box[7][0] = 1;
        redcoin[7][0] = 1;
        omirrorsR.add(new Omirror(0, 7, 0, 2));
        box[6][5] = 1;
        redcoin[6][5] = 1;
        omirrorsR.add(new Omirror(0, 6, 5, 2));
        box[7][3] = 1;
        redcoin[7][3] = 1;
        omirrorsR.add(new Omirror(0, 7, 3, 2));
        box[7][4] = 1;
        redcoin[7][4] = 1;
        omirrorsR.add(new Omirror(0, 7, 4, 1));
        box[7][6] = 1;
        bluecoin[7][6] = 1;
        omirrorsB.add(new Omirror(1, 7, 6, 1));
        box[9][3] = 1;
        bluecoin[9][3] = 1;
        omirrorsB.add(new Omirror(1, 9, 3, 0));
        box[9][4] = 1;
        bluecoin[9][4] = 1;
        omirrorsB.add(new Omirror(1, 9, 4, 3));
        box[4][3] = 2;
        redcoin[4][3] = 1;
        tmirrorsR.add(new Tmirror(0, 4, 3, 1));
        box[5][3] = 2;
        redcoin[5][3] = 1;
        tmirrorsR.add(new Tmirror(0, 5, 3, 0));
        box[4][4] = 2;
        bluecoin[4][4] = 1;
        tmirrorsB.add(new Tmirror(1, 4, 4, 0));
        box[5][4] = 2;
        bluecoin[5][4] = 1;
        tmirrorsB.add(new Tmirror(1, 5, 4, 1));
    }

    private void getCor() {
        for (int i = 0; i < 11; i++) {
            xc[i] = startx + i * lenght;
        }
        for (int i = 0; i < 9; i++) {
            yc[i] = starty + i * lenght;
        }
    }

    private void setPaint(Paint paint, int color, double stroke, int size) {
        paint.setColor(color);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
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
        drawGame();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float px = event.getX();
        float py = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                for (int i = 0; i < 10; i++) {
                    if ((px - xc[i]) < lenght) {
                        xCo = i;
                        break;
                    }
                }
                for (int j = 0; j < 8; j++) {
                    if ((py - yc[j])<lenght){
                        yCo = j;
                        break;
                    }
                }
                if(xCo < 10 && yCo<8){
                    play = true;
                }
        }
        invalidate();
        return true;
    }

    private void drawbor() {
        for (int i = 0; i < 11; i++) {
            mcan.drawLine(startx + i * lenght, starty, startx + i * lenght, endy, border);
        }
        for (int i = 0; i < 9; i++) {
            mcan.drawLine(startx, starty + i * lenght, endx, starty + i * lenght, border);
        }
    }



    private void omirror(int x, int y, int dir, int color) {
        Path path = new Path();
        Paint paint = new Paint();
        if (color == 0)
            paint = p1;
        else
            paint = p2;
        if (dir == 0) {
            path.moveTo(xc[x], yc[y + 1]);
            path.lineTo(xc[x + 1], yc[y + 1]);
            path.lineTo(xc[x + 1], yc[y]);
            path.lineTo(xc[x], yc[y + 1]);
        } else if (dir == 1) {
            path.moveTo(xc[x], yc[y]);
            path.lineTo(xc[x], yc[y + 1]);
            path.lineTo(xc[x + 1], yc[y + 1]);
            path.lineTo(xc[x], yc[y]);
        } else if (dir == 2) {
            path.moveTo(xc[x], yc[y]);
            path.lineTo(xc[x], yc[y + 1]);
            path.lineTo(xc[x + 1], yc[y]);
            path.lineTo(xc[x], yc[y]);
        } else if (dir == 3) {
            path.moveTo(xc[x], yc[y]);
            path.lineTo(xc[x + 1], yc[y]);
            path.lineTo(xc[x + 1], yc[y + 1]);
            path.lineTo(xc[x], yc[y]);
        }
        mcan.drawPath(path, paint);
    }

    private void tmirror(int x, int y, int dir, int color) {
        Paint paint = new Paint();
        if (color == 0)
            paint = p1;
        else
            paint = p2;
        if (dir == 1)
            mcan.drawLine(xc[x], yc[y], xc[x + 1], yc[y + 1], paint);
        else if (dir == 0)
            mcan.drawLine(xc[x], yc[y + 1], xc[x + 1], yc[y], paint);
    }

    private void protect(int x, int y, int color) {
        Paint paint = new Paint();
        if (color == 0)
            paint = p1;
        else
            paint = p2;
        Path path = new Path();
        path.moveTo(xc[x], yc[y + 1]);
        path.lineTo(xc[x + 1], yc[y + 1]);
        path.lineTo(xc[x] + lenght / 2, yc[y]);
        mcan.drawPath(path, paint);
    }

    private void king(int x, int y, int color) {
        Paint paint = new Paint();
        if (color == 0)
            paint = p1;
        else
            paint = p2;
        mcan.drawCircle(xc[x] + (lenght / 2), yc[y] + (lenght / 2), lenght / 2 - 20, paint);
    }

    private Omirror getmirr(ArrayList<Omirror> omirrors, int x, int y) {
        Omirror omirror = new Omirror();
        for (int i = 0; i < omirrors.size(); i++) {
            if (omirrors.get(i).getPosx() == x && omirrors.get(i).getPosy() == y) {
                omirror = omirrors.get(i);
                return omirror;
            }
        }
        return omirror;
    }

    private Tmirror getTmirr(ArrayList<Tmirror> tmirrors, int x, int y) {
        Tmirror tmirror = new Tmirror();
        for (int i = 0; i < tmirrors.size(); i++) {
            if (tmirrors.get(i).getPosx() == x && tmirrors.get(i).getPosy() == y) {
                tmirror = tmirrors.get(i);
                return tmirror;
            }
        }
        return tmirror;
    }

    private Protector getPro(ArrayList<Protector> protectors, int x, int y) {
        Protector protector = new Protector();
        for (int i = 0; i < protectors.size(); i++) {
            if (protectors.get(i).getPosx() == x && protectors.get(i).getPosy() == y) {
                protector = protectors.get(i);
                return protector;
            }
        }
        return protector;
    }


    private void drawGame() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                if (box[i][j] == 1) {
                    if (redcoin[i][j] == 1) {
                        Omirror omirror = getmirr(omirrorsR, i, j);
                        omirror(i, j, omirror.getDir(), omirror.getColor());
                    } else if (bluecoin[i][j] == 1) {
                        Omirror omirror = getmirr(omirrorsB, i, j);
                        omirror(i, j, omirror.getDir(), omirror.getColor());
                    }
                } else if (box[i][j] == 2) {
                    if (redcoin[i][j] == 1) {
                        Tmirror tmirror = getTmirr(tmirrorsR, i, j);
                        tmirror(i, j, tmirror.getDir(), tmirror.getColor());

                    } else if (bluecoin[i][j] == 1) {
                        Tmirror tmirror = getTmirr(tmirrorsB, i, j);
                        tmirror(i, j, tmirror.getDir(), tmirror.getColor());
                    }
                } else if (box[i][j] == 4) {
                    if (redcoin[i][j] == 1) {
                        king(i, j, 0);
                    } else if (bluecoin[i][j] == 1) {
                        king(i, j, 1);
                    }
                } else if (box[i][j] == 3) {
                    if (redcoin[i][j] == 1) {
                        Protector protector = getPro(protectorsR, i, j);
                        protect(i, j, protector.getColor());
                    } else if (bluecoin[i][j] == 1) {
                        Protector protector = getPro(protectorsB, i, j);
                        protect(i, j, protector.getColor());
                    }
                }
            }
        }
    }

    private void changeO(int move){
        Omirror omirror = new Omirror();
        int id = 20;
        if(redplay) {
            for (int i = 0; i <omirrorsR.size(); i++) {
                if(omirrorsR.get(i).getPosx()==xCo&&omirrorsR.get(i).getPosy()==yCo){
                   omirror = omirrorsR.get(i);
                    id=i;
                   break;
                }
            }
        }else {
            for (int i = 0; i <omirrorsB.size(); i++) {
                if(omirrorsB.get(i).getPosx()==xCo&&omirrorsB.get(i).getPosy()==yCo){
                    omirror = omirrorsR.get(i);
                    id = i;
                    break;
                }
            }
        }
        if(move==0)
            omirror.up();
        else if(move==1)
            omirror.down();
        else if(move==2)
            omirror.left();
        else if(move==3)
            omirror.right();
        else if(move==4)
            omirror.ul();
        else if (move==5)
            omirror.ur();
        else if(move==6)
            omirror.dl();
        else if(move==7)
            omirror.dr();
        if(redplay)
            omirrorsR.set(id,omirror);
        else
            omirrorsB.set(id,omirror);
    }

    public void upmove() {
        Toast.makeText(context, "Up", Toast.LENGTH_SHORT).show();
        if(play) {
            mcan.drawColor(white);
            if (yCo > 0) {
                if (box[xCo][yCo] == 0)
                    return;
                else if (box[xCo][yCo] == 1) {
                    box[xCo][yCo] = 0;
                    box[xCo][yCo-1] = 1;
                    if (redplay) {
                        if(redcoin[xCo][yCo]==1){
                          redcoin[xCo][yCo] = 0;
                          redcoin[xCo][yCo-1] = 1;
                          changeO(0);
                        }
                    }

                }
            }
        }
        invalidate();
    }

    public void downmove() {
    }

    public void leftmove() {
    }

    public void rightmove() {
    }

    public void ulmove() {
    }

    public void urmove() {
    }

    public void drmove() {
    }

    public void dlmove() {
    }

    public void rcmove() {
    }

    public void ramove() {
    }
}

