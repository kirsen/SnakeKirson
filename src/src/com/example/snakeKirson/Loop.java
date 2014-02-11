package com.example.snakeKirson;

import android.graphics.*;

import java.lang.*;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 15.10.13
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
public class Loop extends Thread {
    /**Объект класса*/
    private GameViewSurface view;
//    public Bitmap mBitmap;
//    public Canvas mCanvas;
//    public Paint paint, mBitmapPaint;
//    public Point canvasSize;

    protected Action _action;
    protected boolean running = false;

    public Loop(GameViewSurface view) {
        this.view = view;
//        canvasSize = new Point((int)convertDpToPixel(800, context), (int)convertDpToPixel(380, context));
//
//        mBitmap = Bitmap.createBitmap(canvasSize.x, canvasSize.y, Bitmap.Config.ARGB_8888);
//        mCanvas = new Canvas(mBitmap);
//        mBitmapPaint = new Paint(Paint.DITHER_FLAG);

    };

    /*public void Start() {
        this.SetRunning(true);
        this.Run();
    };

    public void Stop() {
        this.SetRunning(false);
    };*/

    public void SetAction(Action action) {
        this._action = action;
    };

    public void Step(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
//        this._action.Update();
//        this._action.Draw(snakeKirson);

    }

    /**Задание состояния потока*/
    public void SetRunning(boolean run)
    {
        running = run;
    }

    /** Действия, выполняемые в потоке */
    public void run()
    {
        while (running)
        {
            Canvas canvas = null;
            try
            {
                // подготовка Canvas-а
                canvas = view.getHolder().lockCanvas();
                synchronized (view.getHolder())
                {
                    // собственно рисование
                    Step(canvas);

                    try {
                        Thread.sleep(1000);

                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
            //catch (Exception e) { throw e;}
            finally
            {
                if (canvas != null)
                {
                    view.getHolder().unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}