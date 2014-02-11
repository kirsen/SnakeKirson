package com.example.snakeKirson;

import android.graphics.Canvas;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */
public interface ISnakeItem {
    public void Update(/*Queue queue*/);
    public void Draw(Canvas canvas);
}

