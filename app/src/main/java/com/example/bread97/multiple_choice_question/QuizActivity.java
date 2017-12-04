package com.example.bread97.multiple_choice_question;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.bread97.multiple_choice_question.R.id.choice1;
import static com.example.bread97.multiple_choice_question.R.id.choice2;
import static com.example.bread97.multiple_choice_question.R.id.choice3;
import static com.example.bread97.multiple_choice_question.R.id.btnSubmit;

public class QuizActivity extends AppCompatActivity {

    private QuestionBank mQuestionBank = new QuestionBank();
    TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;

    private String mAnswer;
    int mScore = 0;
    int mhighScore = 0;


    private int mQuestionNumber = 0;


    public Button btnSubmit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        init();
        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(choice1);
        mButtonChoice2 = (Button) findViewById(choice2);
        mButtonChoice3 = (Button) findViewById(choice3);

        //When the answer is correct this music will be play
        //choice1 Button music
        final MediaPlayer wallywowMP = MediaPlayer.create(this, R.raw.wallywow);
        final MediaPlayer awwMP = MediaPlayer.create(this, R.raw.aww);


                updateQuestion();

        //Start of Button Listener for Button 1

        //Button logic
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Button logic

                if (mButtonChoice1.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    wallywowMP.start();// Start to play music when the answer is correct

                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                    awwMP.start();
                }
            }

        });
        //End of Button Listerner for Button 1



        //Start of Button Listener for Button 2

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Button logic

                if (mButtonChoice2.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    wallywowMP.start();// Start to play music when the answer is correct

                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    awwMP.start();
                    updateQuestion();
                }
            }

        });

        //End of Button Listerner for Button 2

        //Start of Button Listener for Button 1
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Button logic

                if (mButtonChoice3.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    wallywowMP.start();// Start to play music when the answer is correct

                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();
                } else {
                    awwMP.start();
                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                    updateQuestion();
                }
            }

        });

        //End of Button Listerner for Button 1

    }

    public void init(){
        //Button for open HighScoreActivity
        btnSubmit = (Button)findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Saved the score and move into HighScoreActivity
                SharedPreferences preferences = getSharedPreferences("PREFS",0);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt("lastScore", mScore);
                editor.apply();


                //When the submit button is clicked it will proceed to HighScoreActivity
                Intent intent = new Intent(QuizActivity.this,HighScoreActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void updateQuestion() {
        if (mQuestionNumber < mQuestionBank.getLength()) { //Prevent app from closing after answer all question

            mQuestionView.setText(mQuestionBank.getQuestion(mQuestionNumber));

            mButtonChoice1.setText(mQuestionBank.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionBank.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionBank.getChoice3(mQuestionNumber));

            mAnswer = mQuestionBank.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        } else { //Prompt a message when the test is over
            Toast.makeText(QuizActivity.this, "Test is Over, press submit to proceed", Toast.LENGTH_SHORT).show();
        }
    }

    //Set score's text view to total score
    private void updateScore(int point) {
        mScoreView.setText("" + mScore);

    }


}



