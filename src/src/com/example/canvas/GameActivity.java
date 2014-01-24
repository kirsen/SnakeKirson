package com.example.canvas;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import android.graphics.*;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 22.12.13
 * Time: 11:14
 * To change this template use File | Settings | File Templates.
 */

public class GameActivity extends Activity {

    public Field field;
    public Snake snake;
    public Foods foods;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

       Button mainMenu_button = (Button) findViewById(R.id.mainMenu_button);
        Button left_button = (Button) findViewById(R.id.left_button);
        Button right_button = (Button) findViewById(R.id.right_button);
        Button up_button = (Button) findViewById(R.id.up_button);
        Button down_button = (Button) findViewById(R.id.down_button);
        Button grow_button = (Button) findViewById(R.id.grow_button);

        left_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // snake to left

//                GameViewSurface view = (GameViewSurface) findViewById(R.id.game_view);
                snake.goToLeft();
            }
        });

        right_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // snake to right
                snake.goToRight();
            }
        });

        up_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // snake to up
                snake.goToTop();
            }
        });

        down_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // snake to down
                snake.goToBottom();
            }
        });

        grow_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //
                snake.Grow();
            }
        });

        mainMenu_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        Map<String, Bitmap> resources = new HashMap<String, Bitmap>();

        resources.put("Apple", BitmapFactory.decodeResource(getResources(), R.drawable.apple));

//        resources.put("HeadToLeft", BitmapFactory.decodeResource(getResources(), R.drawable.headtoleft));
        resources.put("HeadToRight", BitmapFactory.decodeResource(getResources(), R.drawable.headtoright));
//        resources.put("HeadToUp", BitmapFactory.decodeResource(getResources(), R.drawable.headtoup));
//        resources.put("HeadToDown", BitmapFactory.decodeResource(getResources(), R.drawable.headtodown));

//        resources.put("VerticalBodyItem", BitmapFactory.decodeResource(getResources(), R.drawable.verticalbodyitem));
        resources.put("HorizontalBodyItem", BitmapFactory.decodeResource(getResources(), R.drawable.horizontalbodyitem));

        resources.put("TailToLeft", BitmapFactory.decodeResource(getResources(), R.drawable.tailtoleft));
//        resources.put("TailToRight", BitmapFactory.decodeResource(getResources(), R.drawable.tailtoright));
//        resources.put("TailToUp", BitmapFactory.decodeResource(getResources(), R.drawable.tailtoup));
//        resources.put("TailToDown", BitmapFactory.decodeResource(getResources(), R.drawable.tailtodown));

        GameViewSurface view = (GameViewSurface) findViewById(R.id.game_view);

        Context context = getBaseContext();

        field = new Field(25, (int)convertDpToPixel(800, context), (int)convertDpToPixel(380, context));
        snake = new Snake(field, resources, 20);
        foods = new Foods(field, resources, 30);

        Action scene = new Action();
        scene.Add((IGameObject)foods);
        scene.Add((IGameObject) snake);
        view.setAction(scene);

        view.setGameLogic(new GameLogic(snake, foods, field));

    }

    //    //переводим dp в пиксели
    public float convertDpToPixel(float dp,Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();

        return dp * (metrics.densityDpi/160f);

    }

}
