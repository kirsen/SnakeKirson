package com.example.snakeKirson;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 15.10.13
 * Time: 15:00
 * To change this template use File | Settings | File Templates.
 */
public class Game {
    protected Loop _loop = new Loop();

    public Game() {

    }

    public void Start() {
        this._loop.Start();
    }

    public void Stop() {
        this._loop.Stop();
    }

}
