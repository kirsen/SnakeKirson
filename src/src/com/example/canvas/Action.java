package com.example.canvas;

import java.util.ArrayList;
import java.util.List;
import android.graphics.Canvas;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 19.11.13
 * Time: 11:20
 * To change this template use File | Settings | File Templates.
 */

public class Action {
    private List<IGameObject> _gameObjects;

    Action()
    {
        _gameObjects = new ArrayList<IGameObject>();
    }

    public void Add(IGameObject gameObject)
    {
        _gameObjects.add(gameObject);
    }

    public void Update() {
        for(IGameObject gameObject : _gameObjects)
        {
            gameObject.Update();
        }

    }

    public void Draw(Canvas canvas) {
        for(IGameObject gameObject : _gameObjects)
        {
            gameObject.Draw(canvas);
        }

    }

}
