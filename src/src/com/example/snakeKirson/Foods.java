package com.example.snakeKirson;

import android.graphics.Bitmap;
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
    protected Map<String, Bitmap> _resources;
    protected GameView _gameView;
    protected int _numberOfFood = 0;
    protected int _width; // ширина поля
    protected int _height;// высота поля

    public Foods(Map<String, Bitmap> resources, GameView gameView, int numberOfFood) {
        this._resources = resources;
        this._gameView = gameView;
        this._numberOfFood = numberOfFood;
        this._width = 400;//gameView.getWidth();
        this._height = 400;//gameView.getHeight();

        Random rand = new Random();
        for(int i=0; i< this._numberOfFood;i++)
        {
            int x = rand.nextInt(this._width);
            int y = rand.nextInt(this._height);
            this.AddFood(new Apple(x, y, this._gameView,this._resources.get("Apple")));
        }

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
