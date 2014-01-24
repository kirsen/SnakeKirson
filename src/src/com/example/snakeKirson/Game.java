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

    public Game(GameView gameView, Map<String, Bitmap> resources) {
        this._gameView = gameView;
        this._resources = resources;

        this._width = gameView.getWidth();
        this._height = gameView.getHeight();

    }

    public void Start() {
        Action scene = new Action();

        this._foods = new Foods(this._resources, this._gameView, 1);
        this._snake = new Snake(this._resources, this._gameView, 5);

        scene.SetFoods(this._foods);
        scene.SetSnake(this._snake);

        this._gameView.SetAction(scene);

    }

    public void Stop() {
        this._gameView.Stop();
    }
}
