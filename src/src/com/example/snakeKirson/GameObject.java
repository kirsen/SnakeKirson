package com.example.snakeKirson;

import android.graphics.Canvas;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 19.11.13
 * Time: 11:26
 * To change this template use File | Settings | File Templates.
 */

interface IGameObject {
    public void Update();
    public void Draw(Canvas canvas);
}

public class GameObject implements IGameObject {
    public void Update() {};

    public void Draw(Canvas canvas) {};
}
