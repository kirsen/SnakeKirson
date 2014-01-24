package com.example.canvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Random;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
public class Head extends Item implements ISnakeItem {

    public Head(Field field, Map<String, Bitmap> resources/*, Canvas canvas*/, Queue queue) {
        _field = field;
        this._resources = resources;
//        this._canvas = canvas;
        this._pos = _field.GetPoint(queue.firstElement().x, queue.firstElement().y);
        this._image = this._resources.get("HeadToRight");

        //this.Update(queue);
    }

    public void Update(Queue queue) {
        this._pos = _field.GetPoint(queue.firstElement().x, queue.firstElement().y);

    }

    public void Draw(Canvas canvas) {
        android.graphics.Matrix m = new android.graphics.Matrix();
        m.postTranslate(this._pos.x, this._pos.y);
        //m.postScale((float)0.3,(float)0.3); // size

        canvas.drawBitmap(this._image, m, null);
    }

}
