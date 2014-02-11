package com.example.snakeKirson;

//import towe.def.GameView.GameThread;
import android.content.Context;
        import android.util.AttributeSet;
import android.util.Log;
        import android.view.SurfaceHolder;
import android.view.SurfaceView;

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

    public void Start()
    {
        Log.d("GameViewSurface", "Started!");
        _loopThread.setRunning(true);
        _loopThread.start();

    }

    public void Stop()
    {
        boolean retry = true;
        _loopThread.setRunning(false);

//        while (retry) {
//            try {
//                // ожидание завершение потока
//                _loopThread.join();
//                retry = false;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//
//            }
//        }
        Log.d("GameViewSurface", "Stoped!");
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        _loopThread.setSurfaceHolder(surfaceHolder);
        Start();

        Log.d("GameViewSurface", "surfaceCreated");

    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        surfaceHolder.setFixedSize(i2,i3);
        _loopThread._surfaceHolder = surfaceHolder;
        Log.d("GameViewSurface", "surfaceChanged");
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Stop();
       Log.d("GameViewSurface", "surfaceDestroyed");
    }
}
