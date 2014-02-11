package com.example.snakeKirson;

import android.content.res.Resources;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:39
 * To change this template use File | Settings | File Templates.
 */
class Queue
{
    private List<QueueItem> _vectorQueue = new ArrayList<QueueItem>();

    Queue(int snakeLength) {

        for(int i=0;i<snakeLength;i++) {
            this.push(new QueueItem(new Point(i+Core.resources.getInteger(R.integer.startSnakePosX), Core.resources.getInteger(R.integer.startSnakePosY)), new Point(1,0)));
        }

    }

    public void push( QueueItem newElement )
    {
        _vectorQueue.add(newElement);
    }

    public synchronized QueueItem pop()
    {
        if ( !empty() )
        {
            QueueItem first = _vectorQueue.get(0);
            _vectorQueue.remove(0);
            return first;
        }
        return null;
    }

    public boolean empty()
    {
        return _vectorQueue.isEmpty();
    }

    public QueueItem firstElement()
    {
        return _vectorQueue.get(_vectorQueue.size()-1);
    }

    public QueueItem lastElement()
    {
        return _vectorQueue.get(0);

    }

    public synchronized QueueItem get(int index)
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