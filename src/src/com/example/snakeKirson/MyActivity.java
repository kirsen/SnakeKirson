package com.example.snakeKirson;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {

    private Game _currentGame = new Game();

    public void Start_Click(View v) {
        //this._currentGame.Start();
//        TextView edtext;
//        edtext = (TextView)findViewById(R.id.textView);
//        edtext.setText("WIEHFJILWEF");

        Intent i = new Intent(this, Game.class);
        startActivity(i);


    }

    public void Exit_Click(View v) {
        //this._currentGame.Stop();
        this.finish();
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //Game s = new Game();

    }

    /** Start a new game with the given difficulty level */
    private void startGame(int i) {
        //Intent intent = new Intent(this,Game.class);
        //intent.putExtra("",i);
        //startActivity(intent);
    }
}
