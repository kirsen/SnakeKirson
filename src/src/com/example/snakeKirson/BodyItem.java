package com.example.snakeKirson;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 21.12.13
 * Time: 12:44
 * To change this template use File | Settings | File Templates.
 */
public class BodyItem extends Item {
    protected int _index;

    public BodyItem(Map<String, Bitmap> resources, GameView gameView, Queue queue, int index) {
        this._resources = resources;
        this._gameView = gameView;
        this._index = index;
    }

    public void Update(Queue queue) {
        this._pos = queue.get(this._index);

        // select image
    }

    public void Draw(Canvas canvas) {
        android.graphics.Matrix m = new android.graphics.Matrix();
        m.postTranslate(this._pos.x, this._pos.y);
        m.postScale((float)1,(float)1); // size

        //canvas.drawBitmap(this._image, m, null);
    }
}
