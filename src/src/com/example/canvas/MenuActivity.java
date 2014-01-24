package com.example.canvas;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

/**
 * Created with IntelliJ IDEA.
 * User: kira
 * Date: 09.01.14
 * Time: 18:35
 * To change this template use File | Settings | File Templates.
 */
public class MenuActivity  extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button play_button = (Button) findViewById(R.id.play_button);
        Button exit_button = (Button) findViewById(R.id.exit_button);

        play_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, GameActivity.class));
            }
        });

        exit_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }
}