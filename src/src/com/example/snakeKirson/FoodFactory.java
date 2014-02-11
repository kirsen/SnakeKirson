package com.example.snakeKirson;

import android.content.res.Resources;
import android.graphics.Bitmap;

import java.util.Map;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 11.02.14
 * Time: 11:32
 * To change this template use File | Settings | File Templates.
 */

public class FoodFactory {
    private Field _field;
    private Map<String, Bitmap> _resources;

    public FoodFactory(Field field, Map<String, Bitmap> resources)
    {
        _field = field;
        _resources = resources;
    }

    public Food GetRandomFood()
    {
        Random rand = new Random();

        int numberOfFoodTypes = 1;
        Food food;

        int indexOfFood = rand.nextInt(numberOfFoodTypes);
        switch (indexOfFood)
        {
            case 1:
            {
                food = new Apple(_field, _resources);
            }
        }

        return new Apple(_field, _resources);

    }
}
