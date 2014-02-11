package com.example.snakeKirson;

import java.util.*;
import android.graphics.*;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:08
 * To change this template use File | Settings | File Templates.
 */
public class FieldItem {
    public Point pos;
    public List<Object> objects = new ArrayList<Object>();

    FieldItem(Point point) {
        pos = point;
    }
}
