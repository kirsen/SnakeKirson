package com.example.snakeKirson;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

import java.util.Map;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 15.10.13
 * Time: 15:05
 * To change this template use File | Settings | File Templates.
 */
public class Tail extends Item  implements ISnakePart {
    public Tail(Map<String, Bitmap> resources, GameView gameView, Queue queue) {
        this._resources = resources;
        this._gameView = gameView;
        this.Update(queue);
    }

    public void Update(Queue queue) {
        this._pos.x = queue.lastElement().x;
        this._pos.y = queue.lastElement().y;

        this._image = this._resources.get("TailToLeft");
        // select image
    }

    public void Draw(Canvas canvas) {
        android.graphics.Matrix m = new android.graphics.Matrix();
        m.postTranslate(this._pos.x, this._pos.y);
        m.postScale((float)0.3,(float)0.3); // size

        canvas.drawBitmap(this._image, m, null);
    }
}
