package com.example.snakeKirson;

import android.graphics.Bitmap;
import android.graphics.Point;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */

public class Item
{
    protected Field _field;
    protected Queue _queue;
    protected Map<String, Bitmap> _resources;
    protected Bitmap _image;
    protected Point _pos;
    protected Point _posInFied;
    protected Point _dirrection;


}