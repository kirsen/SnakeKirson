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


import java.util.*;

public class MyActivity extends Activity {

    private Game _game;

    public void Start_Click(View v) {

        GameView gameView = new GameView(this);

        Map<String, Bitmap> resources = new HashMap<String, Bitmap>();

        resources.put("Apple", BitmapFactory.decodeResource(getResources(), R.drawable.apple));

        resources.put("HeadToLeft", BitmapFactory.decodeResource(getResources(), R.drawable.headtoleft));
        resources.put("HeadToRight", BitmapFactory.decodeResource(getResources(), R.drawable.headtoright));
        resources.put("HeadToUp", BitmapFactory.decodeResource(getResources(), R.drawable.headtoup));
        resources.put("HeadToDown", BitmapFactory.decodeResource(getResources(), R.drawable.headtodown));

        resources.put("VerticalBodyItem", BitmapFactory.decodeResource(getResources(), R.drawable.verticalbodyitem));
        resources.put("HorizontalBodyItem", BitmapFactory.decodeResource(getResources(), R.drawable.horizontalbodyitem));

        resources.put("TailToLeft", BitmapFactory.decodeResource(getResources(), R.drawable.tailtoleft));
        resources.put("TailToRight", BitmapFactory.decodeResource(getResources(), R.drawable.tailtoright));
        resources.put("TailToUp", BitmapFactory.decodeResource(getResources(), R.drawable.tailtoup));
        resources.put("TailToDown", BitmapFactory.decodeResource(getResources(), R.drawable.tailtodown));

        setContentView(gameView);
        this._game = new Game(gameView, resources);
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

        //GameVie d = new  GameVie();

    }

}
