package com.example.bread97.multiple_choice_question;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homepage extends AppCompatActivity {

    public Button beginTest;

    public void init(){
        //Button for open another activity
        beginTest = (Button)findViewById(R.id.beginTest);
        beginTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Assign Button link page
                Intent start1 = new Intent(Homepage.this,QuizActivity.class);
                startActivity(start1);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        init(); //Open another activity by clicking the button
    }

    public void quit(View v){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
