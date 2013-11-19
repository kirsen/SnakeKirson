package com.example.snakeKirson;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 15.10.13
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
public class Loop {
    protected Timer _timer = new Timer();
    protected Action _action;

    protected int _fps = 30;

    public Loop() {

    };

    public Loop(int fps) {
        this._fps = fps;
    };

    public void Start() {
        TimerTask task = new TimerTask() {
            public void run() {

            }
        };

        this._timer.schedule(task, 100);
    };

    public void Stop() {
        this._timer.cancel();
    };

    public void SetAction(Action action) {
        this._action = action;
    };

    private void _collisionDetected() {

    };

    private void _clear() {

    };

    private void _doEvents() {

    };

    private void _update() {

    };

    private void _draw() {
        this._action.Draw();
    };

}
