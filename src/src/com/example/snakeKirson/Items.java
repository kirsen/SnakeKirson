package com.example.snakeKirson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 15.10.13
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
public class Items {
    protected List<Item> _items = new ArrayList<Item>();

    public Items() {

    };

    public void Add(Item item) {
        this._items.add(item);
    }

    public void Remove(Item item) {
        this._items.remove(item);
    }

    public void RemoveAll() {
        this._items.removeAll(this._items);
    }
}
