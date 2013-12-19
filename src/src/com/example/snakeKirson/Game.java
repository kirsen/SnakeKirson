package com.example.snakeKirson;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.Dictionary;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 26.11.13
 * Time: 12:06
 * To change this template use File | Settings | File Templates.
 */
public class Game {
    private GameView _gameView;

    private Snake _snake;
    private Foods _foods;
    private Map<String, Bitmap> _resources;
    private int _width;
    private int _height;

    public Game(GameView gameView, Map<String, Bitmap> resources, int width, int height) {
        this._gameView = gameView;
        this._resources = resources;
        this._width = width;
        this._height = height;

    }

    public void Start() {
        Action scene = new Action();

        this._foods = new Foods();
        this._snake = new Snake();

        Random rand = new Random();
        for(int i=0; i< 3;i++)
        {
            int x = rand.nextInt(this._width);
            int y = rand.nextInt(this._height);
            this._foods.AddFood(new Apple(x, y, this._gameView,this._resources.get("Apple")));
        }
        scene.SetFoods(this._foods);

        this._snake.AddHead(new Head(this._gameView,this._resources.get("Head")));
        for(int i=0; i< 3;i++)
        {
            this._snake.AddItem(new Item(this._gameView,this._resources.get("Item")));
        }
        this._snake.AddTail(new Tail(this._gameView,this._resources.get("Tail")));

        scene.SetSnake(this._snake);

        this._gameView.SetAction(scene);

    }

    public void Stop() {
        this._gameView.Stop();
    }
}
