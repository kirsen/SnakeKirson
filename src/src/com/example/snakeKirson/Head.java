package com.example.snakeKirson;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
public class Head extends Item implements IGameObject
{
    public Head(Field field, Map<String, Bitmap> resources, Queue queue)
    {
        _field = field;
        _queue = queue;
        this._resources = resources;
        SetPosInFild(_field.GetPoint(queue.firstElement().point.x, queue.firstElement().point.y));
        this._image = this._resources.get("HeadToRight");

    }

    public void Update(/*Queue queue*/) {
        QueueItem headQueueItem = _queue.firstElement();
        if(headQueueItem.dirrection.x == 1 && headQueueItem.dirrection.y == 0)
        {
            this._image = this._resources.get("HeadToRight");

        } else

        if(headQueueItem.dirrection.x == -1 && headQueueItem.dirrection.y == 0)
        {
            this._image = this._resources.get("HeadToLeft");

        } else

        if(headQueueItem.dirrection.x == 0 && headQueueItem.dirrection.y == 1)
        {
            this._image = this._resources.get("HeadToBottom");

        } else

        if(headQueueItem.dirrection.x == 0 && headQueueItem.dirrection.y == -1)
        {
            this._image = this._resources.get("HeadToTop");

        }
        _posInFied = headQueueItem.point;
        this._dirrection = headQueueItem.dirrection;
        this._pos = _field.GetPoint(headQueueItem.point.x,headQueueItem.point.y);

    }

    public void Draw(Canvas canvas) {
        android.graphics.Matrix m = new android.graphics.Matrix();
        m.postTranslate(GetPosInFild().x, GetPosInFild().y);
        //m.postScale((float)0.3,(float)0.3); // size

        canvas.drawBitmap(this._image, m, null);
    }

    public Point GetPosInFild()
    {
        return _pos;
    }
    public void SetPosInFild(Point pos)
    {
        _pos = pos;
    }

    public Point GetPosOnFild()
    {
        return _posInFied;
    }

    public boolean IntersectWith(IGameObject gameObject)
    {
        if(gameObject.GetPosInFild().equals(this.GetPosInFild()))
        {
            return true;
        } else {
            return false;
        }
    }

}
