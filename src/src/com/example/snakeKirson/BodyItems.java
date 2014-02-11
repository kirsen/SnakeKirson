package com.example.snakeKirson;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */
public class BodyItems implements ISnakeItem {
    protected Field _field;
    protected List<BodyItem> _items = new ArrayList<BodyItem>();
    protected Map<String, Bitmap> _resources;

    public BodyItems(/*Field field, Map<String, Bitmap> resources, Queue queue*/) {
//        _field = field;
//        _queue = queue;
//        this._resources = resources;

//        for(int i=1; i< queue.size()-1; i++) {
//            this.Add(new BodyItem(field, resources, queue, i));
//        }

    };

    public void Update(/*Queue queue*/) {
        for(BodyItem item : this._items) {
            item.Update(/*queue*/);
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

    public int GetSize()
    {
        return _items.size();
    }

    public List<BodyItem> GetItemsList()
    {
        return _items;
    }

    public boolean IntersectWith(IGameObject gameObject)
    {
        for(BodyItem bodyItem: _items)
        {
            if(bodyItem.GetPosInFild().equals(gameObject.GetPosInFild()))
            {
                return true;
            }
        }
        return false;

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
