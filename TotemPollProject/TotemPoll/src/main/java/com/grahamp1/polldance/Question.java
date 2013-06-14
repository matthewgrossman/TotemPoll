package com.grahamp1.polldance;

import java.io.Serializable ;
import java.util.ArrayList;


public class Question implements Serializable
{
    String text;
    ArrayList <Answer> answers;

    public Question(String text, ArrayList<Answer> answers)
    {
        this.text = text;
        this.answers = new ArrayList<Answer>(answers);
    }

    public String getText()
    {
        return text;
    }

    public ArrayList <Answer> getAnswers()
    {
        return answers;
    }

    public String[] getAnswerList()
    {
        String[] tmp = new String[answers.size()] ;

        int i = 0 ;
        for( Answer ans : answers )
        {
            tmp[i] = ans.getText() ;
            i ++ ;
        }

        return tmp ;
    }


    public void setText(String text)
    {
        this.text = text;
    }

    public void setAnswers(ArrayList <Answer> answers)
    {
        this.answers = answers;
    }
}
