package com.example.snakeKirson;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

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
    private Bitmap mBitmap;

    public Game(GameView gameView, Bitmap mBitmap) {
        this._gameView = gameView;
        this.mBitmap= mBitmap;
    }

    public void Start() {
        Action scene = new Action();

        this._foods = new Foods();


        this._foods.AddFood(new Apple(this._gameView, this.mBitmap));
        scene.SetFoods(this._foods);

        this._gameView.SetAction(scene);

    }

    public void Stop() {
        this._gameView.Stop();
    }
}
