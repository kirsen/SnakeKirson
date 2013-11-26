package com.example.snakeKirson;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import android.graphics.Canvas;


/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 15.10.13
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
public class Loop extends Thread {
    /**Объект класса*/
    private GameView view;

    protected Action _action;
    protected boolean running = false;

    public Loop(GameView view) {
        this.view = view;

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
        this._action.Update();
        this._action.Draw(canvas);

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
                }
            }
            catch (Exception e) { }
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
