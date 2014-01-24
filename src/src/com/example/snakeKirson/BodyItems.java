package com.example.snakeKirson;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 15.10.13
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
public class BodyItems  implements ISnakePart {
    protected List<BodyItem> _items = new ArrayList<BodyItem>();
    protected Map<String, Bitmap> _resources;
    protected GameView _gameView;

    public BodyItems(Map<String, Bitmap> resources, GameView gameView, Queue queue) {
        this._resources = resources;
        this._gameView = gameView;

        for(int i=1; i< queue.size()-1; i++) {
            this.Add(new BodyItem(resources, gameView, queue, i));
        }

        this.Update(queue);

    };

    public void Update(Queue queue) {
        for(BodyItem item : this._items) {
            item.Update(queue);
        }
    }

    public void Draw(Canvas canvas) {
        for(BodyItem item : this._items) {
            item.Draw(canvas);
        }

    }

    public void Add(BodyItem item) {
        this._items.add(item);
    }

    public void Remove(BodyItem item) {
        this._items.remove(item);
    }

    public void RemoveAll() {
        this._items.removeAll(this._items);
    }
}
