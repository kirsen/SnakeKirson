package com.example.canvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */

public class Item implements ISnakeItem {
    protected Field _field;
    protected Map<String, Bitmap> _resources;
    protected Canvas _canvas;
    protected Bitmap _image;
    protected Point _pos = new Point(0,0);

    public void Update(Queue queue) {};

    public void Draw(Canvas canvas) {};

}