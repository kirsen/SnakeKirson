package com.example.snakeKirson;

import android.graphics.Canvas;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 15.10.13
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
public class Foods {
    protected List<Food> _foods = new ArrayList<Food>();

    public Foods() {

    };

    public void Update() {
        for(Food food : this._foods) {
            food.Update();
        }
    }

    public void Draw(Canvas canvas) {
        for(Food food : this._foods) {
            food.Draw(canvas);
        }
    }

    public void AddFood(Food food) {
        this._foods.add(food);
    }

    public void RemoveFood(Food food) {
        this._foods.remove(food);
    }
}
