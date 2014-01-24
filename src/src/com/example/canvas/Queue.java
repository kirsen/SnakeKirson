package com.example.canvas;

import android.graphics.Point;

import java.util.Vector;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */
class Queue
{
    private List<Point> _vectorQueue = new ArrayList<Point>();

    Queue(int snakeLength) {
        for(int i=0;i<snakeLength;i++) {
            this.push(new Point(i, 0));
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