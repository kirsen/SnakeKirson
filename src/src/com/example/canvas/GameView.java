package com.example.canvas;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.*;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.Scroller;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 22.12.13
 * Time: 11:10
 * To change this template use File | Settings | File Templates.
 */
public class GameView extends View {
    public Bitmap mBitmap;
    public Canvas mCanvas;
    public Paint paint, mBitmapPaint;
    public Point canvasSize;

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);

        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();

        canvasSize = new Point((int)convertDpToPixel(800, context), (int)convertDpToPixel(380, context));

        mBitmap = Bitmap.createBitmap(canvasSize.x, canvasSize.y, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
        mBitmapPaint = new Paint(Paint.DITHER_FLAG);

        //определяем параметры кисти, которой будем рисовать сетку и атомы
        //paint =new Paint();
        //paint.setAntiAlias(true);
        //paint.setDither(true);
        //paint.setColor(0xffff0505);
        //paint.setStrokeWidth(5f);
        //paint.setStyle(Paint.Style.STROKE);
        //paint.setStrokeJoin(Paint.Join.ROUND);
        //paint.setStrokeCap(Paint.Cap.ROUND);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmap, 0, 0, mBitmapPaint);
    }

    //переводим dp в пиксели
    public float convertDpToPixel(float dp,Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();

        return dp * (metrics.densityDpi/160f);

    }


}
