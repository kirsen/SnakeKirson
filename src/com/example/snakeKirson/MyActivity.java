package com.example.snakeKirson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyActivity extends Activity {

    private Game _currentGame = new Game();

    public void Start_Click(View v) {
        this._currentGame.Start();

    }

    public void Exit_Click(View v) {
        this.finish();
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Game s = new Game();

    }
}
