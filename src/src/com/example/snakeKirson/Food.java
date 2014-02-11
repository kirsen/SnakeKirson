package com.example.snakeKirson;

import android.graphics.*;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
public class Food implements IGameObject
{
    protected Field _field;
    protected Map<String, Bitmap> _resources;
    protected Point _pos;

//    protected  Bitmap _bmp;

    public void Update() {};
    public void Draw(Canvas canvas) {};

    public boolean IntersectWith(IGameObject gameObject)
    {
        if(GetPosInFild().equals(gameObject.GetPosInFild()))
        {
            return true;
        } else {
            return false;
        }

    }

    public Point GetPosInFild()
    {
        return _pos;
    }
    public void SetPosInFild(Point pos)
    {
        _pos = pos;
    }


}
