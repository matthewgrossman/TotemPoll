package com.grahamp1.polldance;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goToHostHome(View view)
    {
        startActivity(new Intent(this, HostHomeActivity.class));
    }

    public void goToResponseScreen(View view)
    {
        // create and start intent
        Intent intent = new Intent( this , ClientResponseActivity.class ) ;
        intent.putExtra( "question_object" , generateTestQuestion() ) ;

        startActivity( intent ) ;
    }


    // TEST QUESTION
    private Question generateTestQuestion()
    {
        ArrayList<Answer> tmpList = new ArrayList<Answer>() ;

        Answer tmp = new Answer( "Answer 0" , true ) ;
        tmpList.add(tmp) ;

        for( int i = 1 ; i < 5 ; i ++ )
        {
            tmp = new Answer( "Answer " + i , false ) ;
            tmpList.add(tmp) ;
        }

        return new Question( "Test Question" , tmpList ) ;
    }
}