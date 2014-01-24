package com.example.canvas;

import android.graphics.*;

import java.util.Map;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:03
 * To change this template use File | Settings | File Templates.
 */
public class Tail extends Item implements ISnakeItem {
    public Tail(Field field, Map<String, Bitmap> resources,  Queue queue) {
        _field = field;
        this._resources = resources;
        this._pos = _field.GetPoint(queue.lastElement().x, queue.lastElement().y);
        this._image = this._resources.get("TailToLeft");

    }

    public void Update(Queue queue) {
        this._pos = _field.GetPoint(queue.lastElement().x, queue.lastElement().y);

    }

    public void Draw(Canvas canvas) {
        android.graphics.Matrix m = new android.graphics.Matrix();
        m.postTranslate(this._pos.x, this._pos.y);
        m.postScale((float)1,(float)1); // size

        canvas.drawBitmap(this._image, m, null);

        /*Paint paint = new Paint();
        paint.setARGB(1,1,0,0);
        //рисуем сетку
        for(int x=0;x< _field.widthNumberItems;x++) {
           canvas.drawLine((float) x * _field._itemWidth, 0, (float) x * _field._itemWidth, canvasSize.y, paint);
            for(int y=0;y< _field.heightNumberItems;y++) {
                canvas.drawLine(0, (float) y * _field._itemWidth, view.canvasSize.x, (float) y * _field._itemWidth, paint);
            }
        }*/

    }
}
