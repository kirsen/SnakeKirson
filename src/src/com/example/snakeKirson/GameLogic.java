package com.example.snakeKirson;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Point;
import android.util.Log;

import java.util.Objects;

/**
 * Created by sogimu on 1/24/14.
 */
public class GameLogic
{
    private Snake _snake;
    private Foods _foods;
    private Field _field;
    private Activity _activity;
    private GameViewSurface _gameViewSurface;

    GameLogic(Snake snake, Foods foods, Field field, GameViewSurface gvs, Activity activity)
    {
        _snake = snake;
        _foods = foods;
        _field = field;
        _gameViewSurface = gvs;
        _activity = activity;
    }

    public void Update()
    {
//        Log.d("GameLogic", "Start Update()");
        if(_snake.GetBodyItems().IntersectWith((IGameObject)_snake.GetHead()) || _snake.GetBodyItems().IntersectWith((IGameObject)_snake.GetTail()) )
        {
            Log.d("GameLogic", "HEAD of snake intersect with body of SNAKE!");
            _gameViewSurface.Stop();


        }

        Point headPosInField =  _snake.GetHead().GetPosOnFild();

        if(headPosInField.x < 0 || headPosInField.x > _field.widthNumberItems || headPosInField.y < 0 || headPosInField.y > _field.heightNumberItems-1)
        {
            Log.d("GameLogic", "Have game object out of border!");
            _gameViewSurface.Stop();

        }

        if(_foods.IntersectWith((IGameObject)_snake.GetHead()))
        {
            Log.d("GameLogic", "HEAD of snake intersect with FOODS!");
            _snake.Grow();
            _foods.GetFoodIntersectedWith(_snake.GetHead()).remove();


        }
    }

    private void ShowDialogEndOfGame()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(_activity);
        builder.setTitle("Важное сообщение!")
                .setMessage("Покормите кота!")
                .setIcon(R.drawable.apple)
                .setCancelable(false)
                .setNegativeButton("ОК, иду на кухню",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                _activity.finish();

                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }


}
