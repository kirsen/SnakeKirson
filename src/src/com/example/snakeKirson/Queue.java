package com.example.snakeKirson;

import android.graphics.Point;

import java.util.Vector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;



/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 21.12.13
 * Time: 11:39
 * To change this template use File | Settings | File Templates.
 */
class Queue
{
    private List<Point> _vectorQueue = new ArrayList<Point>();

    Queue(int snakeLength, int speedValue) {
        int x = speedValue;
        int y = speedValue;
        for(int i=0;i<snakeLength;i++) {
            x += speedValue;
            y += speedValue;
            this.push(new Point(x, y));
        }

    }

    public void push( Point newElement )
    {
        _vectorQueue.add(newElement);
    }
    public synchronized Point pop()
    {
        if ( !empty() )
        {
            Point first = _vectorQueue.get(0);
            _vectorQueue.remove(0);
            return first;
        }
        return null;
    }

    public boolean empty()
    {
        return _vectorQueue.isEmpty();
    }

    public Point firstElement()
    {
        return _vectorQueue.get(_vectorQueue.size()-1);
    }

    public Point lastElement()
    {
        return _vectorQueue.get(0);

    }

    public synchronized Point get(int index)
    {
        if ( !empty() )
        {
            return _vectorQueue.get(index);
        }

        return  null;
    }

    public int size()
    {
        return _vectorQueue.size();

    }



}
