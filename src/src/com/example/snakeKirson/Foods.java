package com.example.snakeKirson;

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
    protected List<Food> _foods = new ArrayList<Food>();
    private FoodFactory _foodFactory;

    public Foods(FoodFactory foodFactory)
    {
        _foodFactory = foodFactory;

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

    public void Add(Food food) {
        this._foods.add(food);
    }

    public void AddRandomFood() {
        this._foods.add(_foodFactory.GetRandomFood());
    }

    public void Remove(Food food) {
        this._foods.remove(food);
    }

    public List<Food> GetFoodsList()
    {
        return _foods;
    }

    public boolean IntersectWith(IGameObject gameObject)
    {
        for(Food food: _foods)
        {
            if(food.GetPosInFild().equals(gameObject.GetPosInFild()))
            {
                return true;
            }
        }
        return false;

    }

    public Iterator GetFoodIntersectedWith(IGameObject gameObject)
    {
        for( Iterator<Food> it = _foods.iterator(); it.hasNext();) {
            Food food = it.next();
            if(food.GetPosInFild().equals(gameObject.GetPosInFild()))
            {
                return it;
            }

         }
        return null;
    }

    public Point GetPosInFild()
    {
        return null;
    }
    public void SetPosInFild(Point pos)
    {
//        _pos = pos;
    }

}
