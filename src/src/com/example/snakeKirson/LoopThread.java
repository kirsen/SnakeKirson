package com.example.snakeKirson;

import android.graphics.*;
import android.view.SurfaceHolder;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 21.01.14
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
public class LoopThread extends Thread {
    /**Объект класса*/
    private GameViewSurface _view;
    public SurfaceHolder _surfaceHolder;
    private Action _action;
    private GameLogic _gameLogic;

    /**Переменная задавания состояния потока рисования*/
    private boolean running = false;

    /**Конструктор класса*/
    public LoopThread()
    {
    }

    /**Задание состояния потока*/
    public void setRunning(boolean run)
    {
        running = run;
    }

    /** Действия, выполняемые в потоке */
    public void run() {
        Canvas canvas;

        while (running) {
            canvas = null;
            try {
                canvas = _surfaceHolder.lockCanvas(null);
                synchronized (_surfaceHolder) {


                    canvas.drawColor(Color.CYAN);

                    _action.Update();
                    _action.Draw(canvas);
                    _gameLogic.Update();

                    try {
                        Thread.sleep(250);
                    } catch(InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                }
            } finally {
                if (canvas != null) {
                    _surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }


    public void setAction(Action action) {
        _action = action;

    }

    public void setGameLogic(GameLogic gameLogic) {
        _gameLogic = gameLogic;

    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        _surfaceHolder = surfaceHolder;

    }
}
