package com.example.snakeKirson;

import android.graphics.*;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
public class Apple extends Food implements IGameObject {

    public Apple(Field field, Bitmap bmp, int x, int y)
    {
        SetPosInFild(new Point(x,y));
        _field = field;
        this._bmp = bmp;                    //возвращаем рисунок

//        field.AddObject(x, y, this);
        SetPosInFild(field.GetPoint(x, y));

    }

    public void Update() {
        //Random rand = new Random();

        //this._x = 50;//rand.nextInt(1000);
        //this._y = 50;//rand.nextInt(400);

    }

    public void Draw(Canvas canvas) {
        android.graphics.Matrix s = new android.graphics.Matrix();
        s.postTranslate(GetPosInFild().x, GetPosInFild().y);
        //s.postScale((float)0.1,(float)0.1); // size

        canvas.drawBitmap(this._bmp, s, null);
    }

    public boolean IntersectWith(IGameObject gameObject)
    {
        return false;
    }

}
