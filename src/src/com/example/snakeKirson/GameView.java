package com.example.snakeKirson;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 26.11.13
 * Time: 10:15
 * To change this template use File | Settings | File Templates.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

//import towe.def.GameView.GameThread;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView
{
    private Loop _loop;


    public GameView(Context context)        ///вот тут-то нужно упровлять вторым меню
    {
        super(context);

        _loop = new Loop(this);

        /*Рисуем все наши объекты и все все все*/
        getHolder().addCallback(new SurfaceHolder.Callback()    ///получение области рисования
        {
            /*** Уничтожение области рисования */
            public void surfaceDestroyed(SurfaceHolder holder)
            {
                boolean retry = true;
                _loop.SetRunning(false);

                while (retry)
                {
                    try
                    {
                        // ожидание завершение потока
                        _loop.join();
                        retry = false;
                    }
                    catch (InterruptedException e) { }
                }
            }

            /** Создание области рисования */
            public void surfaceCreated(SurfaceHolder holder)
            {
                _loop.SetRunning(true);
                _loop.start();
                holder.setSizeFromLayout();
            }

            /** Изменение области рисования */
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
            {
                //holder.setFixedSize(5,5);
            }
        });
    }

    /*public Apple createSprite(int resouce) {
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), resouce);
        return new Apple(this, bmp);
    } */

    public void Stop() {
        this._loop.SetRunning(false);
    }

    public void SetAction(Action action) {
        this._loop.SetAction(action);
    }
}

