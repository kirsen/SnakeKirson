package com.example.snakeKirson;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 15.10.13
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
public class Item {
    protected Map<String, Bitmap> _resources;
    protected GameView _gameView;
    protected Bitmap _image;
    protected Point _pos = new Point(0,0);

    public void Update() {

    }

    public void Draw(Canvas canvas) {

    }

}
