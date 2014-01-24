package com.example.canvas;

import java.util.*;
import android.graphics.*;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:01
 * To change this template use File | Settings | File Templates.
 */
public class Foods implements IGameObject
{
    protected Field _field;
    protected List<Food> _foods = new ArrayList<Food>();
    protected Map<String, Bitmap> _resources;
    protected int _numberOfFood = 0;

    public Foods(Field field, Map<String, Bitmap> resources/*, Canvas canvas*/, int numberOfFood) {
        _field = field;
        this._resources = resources;
        this._numberOfFood = numberOfFood;

        for(int i=0; i< this._numberOfFood;i++)
        {
            this.AddFood(new Apple(field, this._resources.get("Apple")));
        }

    };

    public void Update() {
        for(Food food : this._foods) {
            food.Update();
        }
    }

    public void Draw(Canvas canvas) {
        for(Food food : this._foods) {
            food.Draw(canvas);
        }
    }

    public void AddFood(Food food) {
        this._foods.add(food);
    }

    public void RemoveFood(Food food) {
        this._foods.remove(food);
    }

    public List<Food> GetFoodsList()
    {
        return _foods;
    }

}
