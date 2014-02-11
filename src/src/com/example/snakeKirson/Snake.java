package com.example.snakeKirson;

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
        _resources = resources;
        _snakeLength = snakeLength;
        _direction = new Point(1, 0);
        _queue = new Queue(this._snakeLength);

        this.SetHead(new Head(_field, this._resources, this._queue));

        BodyItems bodyItems = new BodyItems();
        for(int i=1; i< _queue.size()-1; i++) {
            bodyItems.Add(new BodyItem(_field, _resources, _queue, i));
        }
        this.SetBodyItems(bodyItems);

        this.SetTail(new Tail(_field, this._resources, this._queue));

    };

    public void Update() {
        _field.RemoveObject(this._queue.firstElement().point.x, this._queue.firstElement().point.y, _head);
        this._queue.push(new QueueItem(new Point(this._queue.firstElement().point.x + _direction.x, this._queue.firstElement().point.y + _direction.y), _direction));
        _field.AddObject(this._queue.firstElement().point.x, this._queue.firstElement().point.y, _head);
        this._queue.pop();

        this._head.Update(/*this._queue*/);
        this._bodyItems.Update(/*this._queue*/);
        this._tail.Update(/*this._queue*/);

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
        QueueItem tailPoint = _queue.firstElement();
        int lastElementIndex = _bodyItems.GetSize();

//        this._queue.push(new Point(tailPoint.x, tailPoint.y));
        this._queue.push(new QueueItem(new Point(this._queue.firstElement().point.x + _direction.x, this._queue.firstElement().point.y + _direction.y), _direction));
        this._bodyItems.Add(new BodyItem(_field, _resources, _queue, lastElementIndex + 1));
    }

    public boolean IntersectWith(IGameObject gameObject)
    {
        if(_head.IntersectWith(gameObject)) return true;
        if(_bodyItems.IntersectWith(gameObject)) return true;
        if(_tail.IntersectWith(gameObject)) return true;
        return false;
    }

    public Point GetPosInFild()
    {
        return _head.GetPosInFild();
    }
    public void SetPosInFild(Point pos)
    {
        _head.SetPosInFild(pos);
    }
}