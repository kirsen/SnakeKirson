package com.example.snakeKirson;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 11.02.14
 * Time: 12:18
 * To change this template use File | Settings | File Templates.
 */

public class Core {
    static Context baseContext;
    static Resources resources;

    static void Init(Context context)
    {
        baseContext = context;
        resources = context.getResources();

    }


}
