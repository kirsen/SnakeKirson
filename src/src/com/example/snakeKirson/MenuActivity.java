package com.example.snakeKirson;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

    private Activity activity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button play_button = (Button) findViewById(R.id.play_button);
        Button exit_button = (Button) findViewById(R.id.exit_button);
        Button instruction_button = (Button)findViewById(R.id.instruction_button);

        instruction_button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActivity.this);
                builder.setTitle("Инструкция к игре")
                        .setMessage("Добро пожаловать в игру SnakeKirson! На протяжении игры вы управляте змеей," +
                                "которая поедает яблоки: перемещение змеи осуществляется касанием экрана " +
                                "относительно текущего положения,чтобы съесть яблоко нужно пересечь яблоко, каждое " +
                                        "съеденное яблоко увеличивает в размере змею;ваша задача-съедать " +
                                        "появляющиеся яблоки,избегая сталкновения змеи с границами игрового поля и " +
                                        "самопересечения змеи.Самопересечение и сталкновение о границы игрового поля" +
                                        "являются проигрышем")
                        .setIcon(R.drawable.apple)
                        .setCancelable(false)
                        .setNegativeButton("ok",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.dismiss();

                                        //   _activity.finish();



                                    }
                                });

                AlertDialog alert = builder.create();
                alert.show();

        }

        });

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