package com.example.snakeKirson;

//import towe.def.GameView.GameThread;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
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
    private Snake _snake;

    private Point _downPoint;
    private Point _upPoint;

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

    public void setAction(Action action, Snake snake) {
        _loopThread.setAction(action);
        _snake = snake;
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO Auto-generated method stub
        boolean touched;
        float touched_x;
        float touched_y;

        touched_x = event.getX();
        touched_y = event.getY();

        Log.d("onTouchEvent pos x = ", ""+touched_x);
        Log.d("onTouchEvent pos y = ", ""+touched_y);

        int action = event.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN:
                touched = true;
                Log.d("onTouchEvent event = ", "ACTION_DOWN");
                _downPoint = new Point((int)touched_x, (int)touched_y);

                break;
            case MotionEvent.ACTION_MOVE:
                touched = true;
                Log.d("onTouchEvent event = ", "ACTION_MOVE");

                break;
            case MotionEvent.ACTION_UP:
                touched = false;
                Log.d("onTouchEvent event = ", "ACTION_UP");
                _upPoint = new Point((int)touched_x, (int)touched_y);

                Point normPoint = new Point(_upPoint.x - _downPoint.x, _upPoint.y - _downPoint.y);
                if(normPoint.x > 0)
                {
                    if(normPoint.y > 0)
                    {
                       if(Math.abs(normPoint.x) > Math.abs(normPoint.y)) {
                           Log.d("onTouchEvent Gesture", "right");
                           _snake.goToRight();

                       } else {
                           Log.d("onTouchEvent Gesture", "down");
                           _snake.goToBottom();
                       }
                    } else {
                        if(Math.abs(normPoint.x) > Math.abs(normPoint.y)) {
                            Log.d("onTouchEvent Gesture", "right");
                            _snake.goToRight();
                        } else {
                            Log.d("onTouchEvent Gesture", "up");
                            _snake.goToTop();
                        }
                    }

                } else {

                    if(normPoint.y > 0)
                    {
                        if(Math.abs(normPoint.x) > Math.abs(normPoint.y)) {
                            Log.d("onTouchEvent Gesture", "left");
                            _snake.goToLeft();
                        } else {
                            Log.d("onTouchEvent Gesture", "down");
                            _snake.goToBottom();
                        }

                    } else {
                        if(Math.abs(normPoint.x) > Math.abs(normPoint.y)) {
                            Log.d("onTouchEvent Gesture", "left");
                            _snake.goToLeft();

                        } else {
                            Log.d("onTouchEvent Gesture", "up");
                            _snake.goToTop();
                        }

                    }
                }

                break;

            default:
        }
        return true; //processed
    }
}
