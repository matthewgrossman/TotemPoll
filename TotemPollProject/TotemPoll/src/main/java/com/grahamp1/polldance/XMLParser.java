package com.grahamp1.polldance;

import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class XMLParser {
    public static String TAG = "XMLParser";

    public ArrayList <Question> getQuestions(String text) throws XmlPullParserException, IOException {

        ArrayList <Question> questions = new ArrayList<Question>();
        ArrayList <Answer> tempAnswers = new ArrayList<Answer>();
        String tempQuestionText = " ";

        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(new StringReader(text));
        parser.nextTag();parser.nextTag();

        //our parser is now looking at the first question now
        //assumes well-formed and exact XML.
        try{
            while(true){
                tempQuestionText = parser.getAttributeValue(0);
                parser.nextTag();
                while(parser.getName().equals("answer")){
                    String tempAnswerText = parser.getAttributeValue(0);
                    boolean tempAnswerIsCorrect = Boolean.valueOf(parser.getAttributeValue(1));
                    tempAnswers.add(new Answer(tempAnswerText,tempAnswerIsCorrect));
                    parser.nextTag();parser.nextTag();
                }
                questions.add(new Question(tempQuestionText,tempAnswers));
                tempAnswers.clear();
                parser.nextTag();
            }
        }
        catch(Exception e){}//we are using an exception as a 'break', lel
        return questions;
    }

    public static void printQuestions(ArrayList <Question> questions){
        for(Question q : questions){
            Log.wtf(TAG, q.getText());
            printAnswers(q.getAnswers());
        }
    }
    public static void printAnswers(ArrayList <Answer> answers){
        for(Answer a : answers){
            Log.wtf(TAG, "Text: " + a.getText() + ", isCorrect: " + a.getIsCorrect());
        }
    }

}
