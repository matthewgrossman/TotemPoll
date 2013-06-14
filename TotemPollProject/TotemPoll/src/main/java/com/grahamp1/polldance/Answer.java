package com.grahamp1.polldance;

import java.io.Serializable;

public class Answer implements Serializable
{
    String text;
    boolean isCorrect;

    public Answer(String text, boolean isCorrect){
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public String getText(){
        return text;
    }

    public boolean getIsCorrect(){
        return isCorrect;
    }

    public void setText(String text){
        this.text = text;
    }

    public void setIsCorrect(boolean isCorrect){
        this.isCorrect = isCorrect;
    }
}
