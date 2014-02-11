package com.example.snakeKirson;

import android.graphics.Point;

/**
 * Created by sogimu on 1/25/14.
 */
class QueueItem
{
    QueueItem(Point p, Point d)
    {
        point = p;
        dirrection = d;
    }
    public Point point;
    public Point dirrection;
}
