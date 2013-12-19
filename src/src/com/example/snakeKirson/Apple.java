package com.example.snakeKirson;

import android.graphics.*;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 15.10.13
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
public class Apple extends Food {

    public Apple(int x, int y, GameView gameView, Bitmap bmp)
    {
        this._gameView = gameView;
        this._bmp = bmp;                    //возвращаем рисунок
        this._y = y;
        this._x = x;

    }

    public void Update() {
        //Random rand = new Random();

        //this._x = 50;//rand.nextInt(1000);
        //this._y = 50;//rand.nextInt(400);

    }

    public void Draw(Canvas canvas) {
        //Random rand = new Random();
        //canvas.drawLine(this._x, this._y, this._x + rand.nextInt(1000), this._y + rand.nextInt(1000), new Paint());
        android.graphics.Matrix s = new android.graphics.Matrix();
        s.postTranslate(this._x, this._y);
        s.postScale((float)1,(float)1); // size

        canvas.drawBitmap(this._bmp, s, null);
    }
}
