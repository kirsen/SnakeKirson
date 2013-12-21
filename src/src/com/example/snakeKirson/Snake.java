package com.example.snakeKirson;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

import  java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 15.10.13
 * Time: 15:03
 * To change this template use File | Settings | File Templates.
 */
public class Snake extends GameObject implements IGameObject {
    protected BodyItems _bodyItems;
    protected Head _head;
    protected Tail _tail;

    protected Map<String, Bitmap> _resources;
    protected GameView _gameView;
    protected int _snakeLength = 3;
    protected int _width; // ширина поля
    protected int _height;// высота поля
    protected Queue _queue;
    protected int _speedValue = 10;
    protected Point _speed;
    protected Point _pos;

    public Snake(Map<String, Bitmap> resources, GameView gameView, int snakeLength) {
        this._resources = resources;
        this._gameView = gameView;
        this._snakeLength = snakeLength;
        this._width = 400;//gameView.getWidth();
        this._height = 400;gameView.getHeight();
        this._speed = new Point(this._speedValue,0);
        this._pos = new Point(0,0);

        this._queue = new Queue(this._snakeLength, this._speedValue);

        this.SetHead(new Head(this._resources, this._gameView, this._queue));
        this.SetBodyItems(new BodyItems(this._resources, this._gameView, this._queue));
        this.SetTail(new Tail(this._resources, this._gameView, this._queue));

    };

    public void Update() {
        this._pos.x += this._speed.x;
        this._pos.y += this._speed.y;

        this._queue.push(new Point(this._pos.x, this._pos.y));
        this._queue.pop();

        this._head.Update(this._queue);
        this._bodyItems.Update(this._queue);
        this._tail.Update(this._queue);

    }

    public void Draw(Canvas canvas) {
        this._head.Draw(canvas);
        this._bodyItems.Draw(canvas);
        this._tail.Draw(canvas);

    }

    public void SetHead(Head head) {
        this._head = head;
    }

    public void SetTail(Tail tail) {
        this._tail = tail;
    }

    public void SetBodyItems(BodyItems bodyItems) {
        this._bodyItems = bodyItems;
    }
}
