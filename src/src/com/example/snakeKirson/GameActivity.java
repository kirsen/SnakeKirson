package com.example.snakeKirson;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

        Resources res = getResources();

        Button mainMenu_button = (Button) findViewById(R.id.mainMenu_button);

        mainMenu_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GameViewSurface view = (GameViewSurface) findViewById(R.id.game_view);
                view.Stop();

                finish();
            }
        });


        Map<String, Bitmap> resources = new HashMap<String, Bitmap>();

        resources.put("Apple", BitmapFactory.decodeResource(getResources(), R.drawable.apple));

        resources.put("HeadToLeft", BitmapFactory.decodeResource(getResources(), R.drawable.headtoleft));
        resources.put("HeadToRight", BitmapFactory.decodeResource(getResources(), R.drawable.headtoright));
        resources.put("HeadToTop", BitmapFactory.decodeResource(getResources(), R.drawable.headtotop));
        resources.put("HeadToBottom", BitmapFactory.decodeResource(getResources(), R.drawable.headtobottom));

        resources.put("VerticalBodyItem", BitmapFactory.decodeResource(getResources(), R.drawable.verticalbodyitem));
        resources.put("HorizontalBodyItem", BitmapFactory.decodeResource(getResources(), R.drawable.horizontalbodyitem));

        resources.put("TailToLeft", BitmapFactory.decodeResource(getResources(), R.drawable.tailtoleft));
        resources.put("TailToRight", BitmapFactory.decodeResource(getResources(), R.drawable.tailtoright));
        resources.put("TailToTop", BitmapFactory.decodeResource(getResources(), R.drawable.tailtotop));
        resources.put("TailToBottom", BitmapFactory.decodeResource(getResources(), R.drawable.tailtobottom));

        GameViewSurface view = (GameViewSurface) findViewById(R.id.game_view);

        Context context = getBaseContext();
        Core.Init(context);

        field = new Field(21, (int)convertDpToPixel(res.getInteger(R.integer.screenWidth), context), (int)convertDpToPixel(res.getInteger(R.integer.screenHeight), context));
        snake = new Snake(field, resources, res.getInteger(R.integer.startSnakeLength));

        foods = new Foods(new FoodFactory(field, resources));
        int startNumberOfApple = res.getInteger(R.integer.startNumberOfApple);

        for(int i=0; i< startNumberOfApple;i++)
        {
            foods.AddRandomFood();
        }

        Action scene = new Action();
        scene.Add((IGameObject) foods);
        scene.Add((IGameObject) snake);

        view.setAction(scene, snake);
        view.setGameLogic(new GameLogic(snake, foods, field, view, this));

    }

    //    //переводим dp в пиксели
    public float convertDpToPixel(float dp,Context context){
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();

        return dp * (metrics.densityDpi/160f);

    }

}
