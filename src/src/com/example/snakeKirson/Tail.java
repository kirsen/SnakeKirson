package com.example.snakeKirson;

import android.graphics.*;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:03
 * To change this template use File | Settings | File Templates.
 */
public class Tail extends Item implements IGameObject
{
    public Tail(Field field, Map<String, Bitmap> resources,  Queue queue) {
        _field = field;
        _queue = queue;
        this._resources = resources;
        SetPosInFild(_field.GetPoint(queue.lastElement().point.x, queue.lastElement().point.y));

        this._image = this._resources.get("TailToLeft");

    }

    public void Update(/*Queue queue*/)
    {
        QueueItem tailQueueItem = _queue.lastElement();
        if(tailQueueItem.dirrection.x == 1 && tailQueueItem.dirrection.y == 0)
        {
            this._image = this._resources.get("TailToLeft");

        } else

        if(tailQueueItem.dirrection.x == -1 && tailQueueItem.dirrection.y == 0)
        {
            this._image = this._resources.get("TailToRight");

        } else

        if(tailQueueItem.dirrection.x == 0 && tailQueueItem.dirrection.y == 1)
        {
            this._image = this._resources.get("TailToTop");

        } else

        if(tailQueueItem.dirrection.x == 0 && tailQueueItem.dirrection.y == -1)
        {
            this._image = this._resources.get("TailToBottom");

        }
        this._pos = _field.GetPoint(tailQueueItem.point.x,tailQueueItem.point.y);

    }

    public void Draw(Canvas canvas) {
        android.graphics.Matrix m = new android.graphics.Matrix();
        m.postTranslate(GetPosInFild().x, GetPosInFild().y); // size

        canvas.drawBitmap(this._image, m, null);

        /*Paint paint = new Paint();
        paint.setARGB(1,1,0,0);
        //рисуем сетку
        for(int x=0;x< _field.widthNumberItems;x++) {
           snakeKirson.drawLine((float) x * _field._itemWidth, 0, (float) x * _field._itemWidth, canvasSize.y, paint);
            for(int y=0;y< _field.heightNumberItems;y++) {
                snakeKirson.drawLine(0, (float) y * _field._itemWidth, view.canvasSize.x, (float) y * _field._itemWidth, paint);
            }
        }*/

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
