package com.example.snakeKirson;

import android.graphics.*;

import java.util.Map;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
public class Apple extends Food implements IGameObject {

    public Apple(Field field, Map<String, Bitmap> resources)
    {
        Point point = field.GetFreePoint();
        SetPosInFild(field.GetPoint(point.x, point.y));
        _field = field;
        _resources = resources;
//        this._bmp = bmp;                    //возвращаем рисунок

    }

    public void Update() {
    }

    public void Draw(Canvas canvas) {
        android.graphics.Matrix s = new android.graphics.Matrix();
        s.postTranslate(GetPosInFild().x, GetPosInFild().y);
        //s.postScale((float)0.1,(float)0.1); // size

        canvas.drawBitmap(_resources.get("Apple"), s, null);
    }

    public boolean IntersectWith(IGameObject gameObject)
    {
        return false;
    }

}
