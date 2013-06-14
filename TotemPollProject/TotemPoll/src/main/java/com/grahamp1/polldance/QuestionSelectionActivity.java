package com.grahamp1.polldance;

import android.app.Activity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Activity for the Question Selection Screen
 *
 * EF, MG
 */
public class QuestionSelectionActivity extends Activity
{
    private static final int QUESTIONS_XML = R.raw.questions ;
    private static final String NEWLINE = System.getProperty( "NEWLINE" ) ;

    private ArrayList<Question> _questions ;

    
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState ) ;
        setContentView( R.layout.activity_question_selection ) ;

        // parse xml
        _questions = importXmlQuestions() ;

        // display
    }


    private ArrayList<Question> importXmlQuestions()
    {
        XMLParser parser = new XMLParser();
        ArrayList<Question> ret = new ArrayList<Question>();

        try
        {
            ret = parser.getQuestions(getXmlString());
        }
        catch (Exception e)
        {}

        return ret ;
    }

    private String getXmlString()
    {
        InputStream stream = getResources().openRawResource(QUESTIONS_XML) ;
        InputStreamReader streamReader = new InputStreamReader(stream) ;
        BufferedReader buffRead = new BufferedReader(streamReader);

        StringBuilder builder  = new StringBuilder();
        String line;

        try
        {
            while ((line = buffRead.readLine()) != null)
            {
                builder.append(line + NEWLINE);
            }
        }
        catch (IOException e)
        {}

        return builder.toString();
    }
}
