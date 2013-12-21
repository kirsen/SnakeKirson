package com.example.snakeKirson;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Random;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 15.10.13
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
public class Head extends Item {
    public Head(Map<String, Bitmap> resources, GameView gameView, Queue queue) {
        this._resources = resources;
        this._gameView = gameView;
        this.Update();
    }

    public void Update(Queue queue) {
        this._pos.x = queue.firstElement().x;
        this._pos.y = queue.firstElement().y;

        this._image = this._resources.get("HeadToLeft");
        // select image
    }

    public void Draw(Canvas canvas) {
        android.graphics.Matrix m = new android.graphics.Matrix();
        m.postTranslate(this._pos.x, this._pos.y);
        m.postScale((float)1,(float)1); // size

        canvas.drawBitmap(this._image, m, null);
    }

}
