package com.example.canvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

import  java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:01
 * To change this template use File | Settings | File Templates.
 */

public class Snake implements IGameObject {
    protected Field _field;
    protected BodyItems _bodyItems;
    protected Head _head;
    protected Tail _tail;

    protected Map<String, Bitmap> _resources;
    protected int _snakeLength = 0;
    protected Queue _queue;
    protected Point _direction;

    public Snake(Field field, Map<String, Bitmap> resources, int snakeLength) {
        _field = field;
        this._resources = resources;
        this._snakeLength = snakeLength;
        _direction = new Point(1, 0);
        this._queue = new Queue(this._snakeLength);

        this.SetHead(new Head(_field, this._resources, this._queue));
        this.SetBodyItems(new BodyItems(_field, this._resources,this._queue));
        this.SetTail(new Tail(_field, this._resources, this._queue));

    };

    public void Update() {
        _field.RemoveObject(this._queue.firstElement().x, this._queue.firstElement().y, _head);
        this._queue.push(new Point(this._queue.firstElement().x + _direction.x, this._queue.firstElement().y + _direction.y));
        _field.AddObject(this._queue.firstElement().x, this._queue.firstElement().y, _head);
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

    public  Head GetHead() {
        return _head;
    }

    public void SetTail(Tail tail) {
        this._tail = tail;
    }

    public  Tail GetTail() {
        return _tail;
    }

    public  BodyItems GetBodyItems()
    {
        return _bodyItems;
    }

    public void SetBodyItems(BodyItems bodyItems) {
        this._bodyItems = bodyItems;
    }

    public void goToTop() {
        if(_direction.y !=1)
        {
            _direction = new Point(0, -1);
        }
    }

    public void goToBottom() {
        if(_direction.y !=-1)
        {
            _direction = new Point(0, 1);
        }
    }

    public void goToLeft() {
        if(_direction.x !=1)
        {
            _direction = new Point(-1, 0);
        }
    }

    public void goToRight() {
        if(_direction.x !=-1)
        {
            _direction = new Point(1, 0);
        }
    }

    public void Grow() {
        Point tailPoint = _queue.firstElement();
        int lastElementIndex = _bodyItems.GetSize();

//        this._queue.push(new Point(tailPoint.x, tailPoint.y));
        this._queue.push(new Point(this._queue.firstElement().x + _direction.x, this._queue.firstElement().y + _direction.y));
        this._bodyItems.Add(new BodyItem(_field, _resources, _queue, lastElementIndex + 1));
    }
}