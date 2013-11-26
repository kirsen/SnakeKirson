package com.example.snakeKirson;

import java.util.ArrayList;
import java.util.List;
import android.graphics.Canvas;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 19.11.13
 * Time: 11:20
 * To change this template use File | Settings | File Templates.
 */

public class Action implements IGameObject {
    protected Snake _snake = new Snake();
    protected Foods _foods = new Foods();

    public void SetFoods(Foods foods) {
        this._foods = foods;
    }

    public void SetSnake(Snake snake) {
        this._snake = snake;
    }

    public void Update() {
        this._foods.Update();
        this._snake.Update();
    }

    public void Draw(Canvas canvas) {
        this._foods.Draw(canvas);
        //this._snake.Draw(canvas);
    }

}

