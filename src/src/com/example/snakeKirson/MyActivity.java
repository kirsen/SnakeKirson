package com.example.snakeKirson;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {

    private Game _game;

    public void Start_Click(View v) {

        GameView gameView = new GameView(this);

        Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);

        setContentView(gameView);
        this._game = new Game(gameView, mBitmap);
        this._game.Start();

    }

    public void Exit_Click(View v) {
        this._game.Stop();
        this.finish();
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }

}
