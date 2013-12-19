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

        resources.put("HeadToLeft", BitmapFactory.decodeResource(getResources(), R.drawable.headToLeft));
        resources.put("HeadToRight", BitmapFactory.decodeResource(getResources(), R.drawable.headToRight));
        resources.put("HeadToUp", BitmapFactory.decodeResource(getResources(), R.drawable.headToUp));
        resources.put("HeadToDown", BitmapFactory.decodeResource(getResources(), R.drawable.headToDown));

        resources.put("VerticalItem", BitmapFactory.decodeResource(getResources(), R.drawable.verticalItem));
        resources.put("HorizontalItem", BitmapFactory.decodeResource(getResources(), R.drawable.horizontalItem));

        resources.put("TailToLeft", BitmapFactory.decodeResource(getResources(), R.drawable.tailToLeft));
        resources.put("TailToRight", BitmapFactory.decodeResource(getResources(), R.drawable.tailToRight));
        resources.put("TailToUp", BitmapFactory.decodeResource(getResources(), R.drawable.tailToUp));
        resources.put("TailToDown", BitmapFactory.decodeResource(getResources(), R.drawable.tailToDown));


        int width = 300;
        int height = 300;

        setContentView(gameView);
        this._game = new Game(gameView, resources, width, height);
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
