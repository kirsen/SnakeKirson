package com.example.canvas;

import android.graphics.Canvas;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:31
 * To change this template use File | Settings | File Templates.
 */
public interface IGameObject {
    public void Update();
    public void Draw(Canvas canvas);

}
