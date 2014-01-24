package com.example.canvas;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.*;

/**
 * Created by sogimu on 1/24/14.
 */
public class GameLogic {
    private Snake _snake;
    private Foods _foods;
    private Field _field;

    GameLogic(Snake snake, Foods foods, Field field)
    {
        _snake = snake;
        _foods = foods;
        _field = field;
    }

    public void Update() {
//        Log.d("GameLogic", "Start Update()");
        Head head = _snake.GetHead();

        for( List<FieldItem> row : _field.GetFieldList()) {
            for( FieldItem item : row) {
                List<Object> gameObjects = item.objects;
                int hasHeadInItem = gameObjects.indexOf(head);
                if(hasHeadInItem != -1)
                {
                    Log.d("GameLogic", "Has head " + item.pos.x + ":" +item.pos.y );
                    List<Food> foodList = _foods.GetFoodsList();
                    for( Iterator<Food> it = foodList.iterator(); it.hasNext();) {
                        Food food = it.next();
                        int hasFoodInItem = gameObjects.indexOf(food);
                        if(hasFoodInItem != -1)
                        {
                            Log.d("GameLogic", "Has APLLE and HEAD " + item.pos.x + ":" +item.pos.y );

                             _snake.Grow();
                            it.remove();
                        }
                    }

                    List<BodyItem> bodyList = _snake.GetBodyItems().GetItemsList();
                    for( Iterator<BodyItem> it = bodyList.iterator(); it.hasNext();)
                    {
                        BodyItem bodyItem = it.next();
                        int hasBodyItemInItem = gameObjects.indexOf(bodyItem);
                        if(hasBodyItemInItem != -1)
                        {
                            Log.d("GameLogic", "Has BODYITEM and HEAD " + item.pos.x + ":" +item.pos.y );

                            //_snake.Grow();
                            //it.remove();
                        }
                    }



                }
            }
        }

//        Log.d("GameLogic", "Stop Update()");
    }

}
