package com.example.canvas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

//import towe.def.GameView.GameThread;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.util.DisplayMetrics;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 20.01.14
 * Time: 17:25
 * To change this template use File | Settings | File Templates.
 */

public class GameViewSurface extends SurfaceView implements SurfaceHolder.Callback
{
    private LoopThread _loopThread;

    private Action _action;

    public GameViewSurface(Context context) {
        super(context);
        getHolder().addCallback(this);
        _loopThread = new LoopThread();

    }

    public GameViewSurface(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        getHolder().addCallback(this);
        _loopThread = new LoopThread();

    }

    public void setAction(Action action) {
        _loopThread.setAction(action);
    }

    public void setGameLogic(GameLogic gameLogic) {
        _loopThread.setGameLogic(gameLogic);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        //To change body of implemented methods use File | Settings | File Templates.
        _loopThread.setSurfaceHolder(surfaceHolder);
        _loopThread.setRunning(true);
        _loopThread.start();

        //Log.d("GameViewSurface", "surfaceCreated");

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        //To change body of implemented methods use File | Settings | File Templates.
        surfaceHolder.setFixedSize(i2,i3);
        _loopThread._surfaceHolder = surfaceHolder;
//        Log.d("GameViewSurface", "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        //To change body of implemented methods use File | Settings | File Templates.
        boolean retry = true;
        _loopThread.setRunning(false);

        while (retry) {
            try {
                // ожидание завершение потока
                _loopThread.join();
                retry = false;
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
       // Log.d("GameViewSurface", "surfaceDestroyed");
    }
}
