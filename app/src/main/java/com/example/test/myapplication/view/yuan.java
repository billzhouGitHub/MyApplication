package com.example.test.myapplication.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.test.myapplication.R;

/**
 * Created by Administrator on 2016/6/22.
 */
public class yuan extends View {

    float kx = 0;
    float ky = 0;
    boolean b = false;
    float sx = 0;
    float sy = 0;
    private Paint paint;
    private Canvas canvas;
    private int pro;
    private int x = 0;
    private int y = 0;

    public yuan(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.RED);
    }

    public yuan(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.parseColor("#c9c6c6"));
        paint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.canvas = canvas;
        x = canvas.getWidth() / 2;
        y = canvas.getHeight() / 2;
        DrawProgess(canvas);
        super.onDraw(canvas);
    }

    public void updata(int i) {
        pro = i;
        invalidate();
    }

    public void DrawProgess(Canvas canvas) {
        int height = canvas.getHeight();
        int width = canvas.getWidth();
        paint.setColor(Color.GRAY);
        canvas.drawCircle(x, y, 101.5F, paint);
        paint.setColor(Color.parseColor("#c9c6c6"));
        canvas.drawCircle(x, y, 100, paint);

        paint.setColor(Color.GRAY);
        canvas.drawCircle(x, y, 82F, paint);

        paint.setColor(Color.WHITE);
        canvas.drawCircle(x, y, 80F, paint);


          /* 设置渐变色 这个正方形的颜色是改变的 */
        Shader mShader = new SweepGradient(y, y, new int[]{Color.RED, Color.GREEN,}, null); // 一个材质,打造出一个线性梯度沿著一条线。
        RectF oval2 = new RectF(x - 80, y - 80, x + 80, y + 80);// 设置个新的长方形，扫描测量
        paint.setShader(mShader);
        canvas.drawArc(oval2, -90, pro, true, paint);
        paint.setShader(null);

        paint.setColor(Color.GRAY);
        canvas.drawCircle(x, y, 60.5F, paint);

        paint.setColor(Color.WHITE);
        canvas.drawCircle(x, y, 60, paint);
        paint.setColor(Color.BLACK);
        paint.setTextSize(30F);
        canvas.drawText("通过率", x - 45, y, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {


        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            kx = event.getX();
            ky = event.getY();
        }

        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            b = true;
        }

        if (event.getAction() == MotionEvent.ACTION_UP) {
            sx = event.getX();
            sy = event.getY();
            int x = (int) Math.abs(kx - sx);
            int y = (int) Math.abs(ky - sy);
            double z = Math.sqrt(x * x + y * y);
        }
        return true;
    }


}
