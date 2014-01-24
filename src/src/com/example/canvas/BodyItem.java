package com.example.canvas;

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

public class BodyItem extends Item implements ISnakeItem {
    protected int _index;

    public BodyItem(Field field, Map<String, Bitmap> resources, Queue queue, int index) {
        _field = field;
        this._resources = resources;
        this._index = index;
        this._image = this._resources.get("HorizontalBodyItem");
        this._pos = _field.GetPoint(queue.get(_index).x, queue.get(_index).y);

    }

    public void Update(Queue queue) {
        this._pos = _field.GetPoint(queue.get(_index).x, queue.get(_index).y);

    }

    public void Draw(Canvas canvas) {
        android.graphics.Matrix m = new android.graphics.Matrix();
        m.postTranslate(this._pos.x, this._pos.y);
        //m.postScale((float)0.3,(float)0.3); // size

        canvas.drawBitmap(this._image, m, null);
    }
}