package com.example.canvas;

import android.graphics.*;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
public class Apple extends Food implements IGameObject {

    public Apple(Field field, Bitmap bmp)
    {
        _field = field;
        this._bmp = bmp;                    //возвращаем рисунок

        Random rand = new Random();

        boolean itemNotEmpty = true;

        while (itemNotEmpty) {
            int x = rand.nextInt(_field.widthNumberItems - 1);
            int y = rand.nextInt(_field.heightNumberItems - 1);

            if(field.GetObjects(x,y).isEmpty()) {
//                x = 25;
//                y = 0;
                field.AddObject(x,y, this);
                this._point = field.GetPoint(x,y);
                itemNotEmpty = false;
            }

        }


    }

    public void Update() {
        //Random rand = new Random();

        //this._x = 50;//rand.nextInt(1000);
        //this._y = 50;//rand.nextInt(400);

    }

    public void Draw(Canvas canvas) {
        android.graphics.Matrix s = new android.graphics.Matrix();
        s.postTranslate(_point.x, _point.y);
        //s.postScale((float)0.1,(float)0.1); // size

        canvas.drawBitmap(this._bmp, s, null);

        Paint paint = new Paint();
        paint.setColor(0xffff0505);

    }

}
