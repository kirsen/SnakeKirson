package com.example.snakeKirson;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 */

public class BodyItem extends Item implements IGameObject
{
    protected int _index;

    public BodyItem(Field field, Map<String, Bitmap> resources, Queue queue, int index) {
        _field = field;
        _queue = queue;
        this._resources = resources;
        this._index = index;
        this._image = this._resources.get("HorizontalBodyItem");
        SetPosInFild(_field.GetPoint(queue.get(_index).point.x, queue.get(_index).point.y));


    }

    public void Update(/*Queue queue*/)
    {
        QueueItem bodyItemQueueItem = _queue.get(_index);
        if((bodyItemQueueItem.dirrection.x == 1 || bodyItemQueueItem.dirrection.x == -1) && bodyItemQueueItem.dirrection.y == 0)
        {
            this._image = this._resources.get("HorizontalBodyItem");

        } else

        if((bodyItemQueueItem.dirrection.y == -1 || bodyItemQueueItem.dirrection.y == 1) && bodyItemQueueItem.dirrection.x == 0)
        {
            this._image = this._resources.get("VerticalBodyItem");

        }
        this._pos = _field.GetPoint(bodyItemQueueItem.point.x,bodyItemQueueItem.point.y);

    }

    public void Draw(Canvas canvas) {
        android.graphics.Matrix m = new android.graphics.Matrix();
        m.postTranslate(GetPosInFild().x, GetPosInFild().y);
        //m.postScale((float)0.3,(float)0.3); // size

        canvas.drawBitmap(this._image, m, null);
    }

    public boolean IntersectWith(IGameObject gameObject)
    {
        if(GetPosInFild().equals(gameObject.GetPosInFild()))
        {
            return true;
        } else {
            return false;
        }
    }

    public Point GetPosInFild()
    {
        return _pos;
    }
    public void SetPosInFild(Point pos)
    {
        _pos = pos;
    }
}