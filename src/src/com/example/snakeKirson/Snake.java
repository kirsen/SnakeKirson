package com.example.snakeKirson;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 15.10.13
 * Time: 15:03
 * To change this template use File | Settings | File Templates.
 */
public class Snake extends GameObject implements IGameObject {
    protected Items _items = new Items();
    protected Head _head;
    protected Tail _tail;

    public Snake() {

    };

    public void Update() {

    }

    public void Draw(Canvas canvas) {

    }

    public void AddHead(Head head) {
        this._head = head;
    }

    public void AddTail(Tail tail) {
        this._tail = tail;
    }

    public void AddItem(Item item) {
        this._items.Add(item);
    }
}
