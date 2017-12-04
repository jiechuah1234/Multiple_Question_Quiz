package com.example.bread97.multiple_choice_question;

/**
 * Created by Bread97 on 29/11/2017.
 */

public class QuestionBank {


    private String mQuestions [] = {
            "Which of the following is an example of non volatile memory?",
            "CD-ROM is a kind of?",
            "What is full form of GUI in terms of computers?",
            "What is LINUX?",
            "Which is most common language used in web designing",
            "Which is full form of IP?"
    };

    private String mChoice[][] ={
            {"ROM", "RAM", "VLSI"},
            {"Optical Disk", "Magnetic disk", "Magneto-Optical Disk"},
            {"Graphical user Instrument", "Graphical user Interface", "Graphical unified Instrument"},
            {"Malware", "Application Program", "Operating System"},
            {"C++", "JAVA", "HTML"},
            {"Interface Program", "Internet Program", "Internet Protocol"}

    };

    private String mCorrectAnswer[] = {"ROM", "Magnetic disk", "Graphical user Interface", "Operating System", "HTML", "Internet Protocol"};


    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }


    public String getChoice1(int a){
        String choice0 = mChoice[a][0];
        return choice0;
    }

    public String getChoice2(int a){
        String choice1 = mChoice[a][1];
        return choice1;
    }

    public String getChoice3(int a){
        String choice2 = mChoice[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswer[a];
        return answer;
    }

    public int getLength(){
        return mQuestions.length;
    }


}
