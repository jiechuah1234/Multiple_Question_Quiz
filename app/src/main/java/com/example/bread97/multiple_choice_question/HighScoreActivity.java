package com.example.bread97.multiple_choice_question;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HighScoreActivity extends AppCompatActivity {

    TextView tv_score;

    int lastScore;
    int highscore = 4;
    public Button tryAgain;
    public Button menu;

    public void init(){
        //Button for open another activity
        tryAgain = (Button)findViewById(R.id.tryAgain);
        tryAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Assign Button link page
                Intent start1 = new Intent(HighScoreActivity.this,QuizActivity.class);
                startActivity(start1);
            }
        });
    }

    public void init1(){
        //Button for open HighScoreActivity
        menu = (Button)findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //When the menu button is clicked it will proceed to HighScoreActivity
                Intent intent1 = new Intent(HighScoreActivity.this,Homepage.class);
                startActivity(intent1);
                finish();
            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        init();
        init1();

        tv_score = (TextView) findViewById(R.id.tv_score);

        SharedPreferences preferences = getSharedPreferences("PREFS",0);
        lastScore = preferences.getInt("lastScore",0);


        if (lastScore > highscore){
            highscore = lastScore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("Highscore", 0);
            editor.apply();

        }
        tv_score.setText("High Score: " + highscore+ "\n" +
                        "Your Score: " + lastScore + "\n");
    }


    public void onBackPresed(){
        Intent intent = new Intent(getApplicationContext(),QuizActivity.class);
        startActivity(intent);
        finish();
    }


}
