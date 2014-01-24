package com.example.canvas;

import java.util.*;
import android.graphics.*;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 10.01.14
 * Time: 15:01
 * To change this template use File | Settings | File Templates.
 */
public class Field {
    private int _widthNumberItems;
    private int _heightNumberItems;

    public int _itemWidth;
    public int widthNumberItems;
    public int heightNumberItems;

//    private Snake _snake;
//    private Foods _foods;
//    private Field _field;

    private List<List<FieldItem>> _items = new ArrayList<List<FieldItem>>();

    Field(int itemWidth, int widthOfScreen, int heightOfScreen) {
        _itemWidth = itemWidth;
        widthNumberItems = (widthOfScreen - (widthOfScreen % itemWidth))/itemWidth;
        heightNumberItems = (heightOfScreen - (heightOfScreen % itemWidth))/itemWidth;

        _widthNumberItems = widthNumberItems + 2;
        _heightNumberItems = heightNumberItems + 2;

        for(int i=-1;i<_widthNumberItems;i++) {
            List<FieldItem> row = new ArrayList<FieldItem>(_heightNumberItems);
            for(int j=-1;j<_heightNumberItems;j++) {
                row.add(new FieldItem(new Point(i*_itemWidth, j*_itemWidth)));
            }
            _items.add(row);
        }

    }

    public void AddObject(int x, int y, Object object) {
        _items.get(x + 1).get(y + 1).objects.add(object);
    }

    public void RemoveObject(int x, int y, Object object)
    {
        _items.get(x + 1).get(y + 1).objects.remove(object);
    }

    public List<Object> GetObjects(int x, int y) {
        return _items.get(x + 1).get(y + 1).objects;
    }

    public Point GetPoint(int x, int y) {
        return _items.get(x + 1).get(y + 1).pos;
    }

    public List<List<FieldItem>>  GetFieldList()
    {
        return _items;
    }

    }
