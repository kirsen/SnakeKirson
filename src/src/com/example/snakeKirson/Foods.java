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
//    protected Field _field;
//    protected Point _pos;
    protected List<Food> _foods = new ArrayList<Food>();
//    protected Map<String, Bitmap> _resources;
//    protected int _numberOfFood = 0;

    public Foods(/*Field field, Map<String, Bitmap> resources, int numberOfFood*/)
    {
//        _field = field;
//        this._resources = resources;
//        this._numberOfFood = numberOfFood;
//        SetPosInFild(new Point(0,0));

//        for(int i=0; i< this._numberOfFood;i++)
//        {
//            Random rand = new Random();
//
//            boolean itemNotEmpty = true;
//
//            while (itemNotEmpty) {
//                int potentialyX = rand.nextInt(_field.widthNumberItems - 1);
//                int potentialyY = rand.nextInt(_field.heightNumberItems - 1);
//
//                if(field.GetObjects(potentialyX,potentialyY).isEmpty()) {
////                x = 25;
////                y = 0;
////                    field.AddObject(potentialyX,potentialyY, this);
////                    SetPosInFild(field.GetPoint(potentialyX,potentialyY));
//                    this.AddFood(new Apple(field, this._resources.get("Apple"), potentialyX, potentialyY));
//                    itemNotEmpty = false;
//                }
//
//            }
//
//        }

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
