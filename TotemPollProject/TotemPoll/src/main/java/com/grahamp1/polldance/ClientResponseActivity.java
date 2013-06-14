package com.grahamp1.polldance ;

import android.app.Activity ;
import android.content.Intent;
import android.os.Bundle ;

import android.view.View;
import android.widget.ArrayAdapter ;
import android.widget.ListView ;
import android.widget.TextView ;

import java.util.ArrayList ;

/**
 * Activity of Client Response Screen
 *
 * EF
 */
public class ClientResponseActivity extends Activity
{
    // ArrayAdapter for loading answers to the ListView
    private ArrayAdapter<String> _adapter ;

    // List of possible answers
    private ArrayList<Answer> _answerList ;

    // ListView
    ListView _listView ;


    /**
     * Initialisation
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState ) ;
        setContentView( R.layout.activity_client_response ) ;

        // load question
        Question question = (Question) getIntent().getSerializableExtra( "question_object" ) ;
        loadQuestion( question ) ;
    }


    /**
     * Loads the question and its answers to the ListView
     *
     * @param question The question to be loaded.
     */
    protected void loadQuestion( Question question )
    {
        _answerList = question.getAnswers() ;

        // add the question to the screen
        TextView questionView = (TextView) findViewById( R.id.cr_question ) ;
        questionView.setText( question.getText() ) ;

        // create answer string list
        String[] answerStrings = new String[_answerList.size()] ;

        int i = 0 ;
        for( Answer a : _answerList )
        {
            answerStrings[i] = a.getText() ;
            i ++ ;
        }


        // load the answers to the ListView
        _adapter = new ArrayAdapter<String>( this , android.R.layout.simple_list_item_single_choice , answerStrings ) ;

        _listView = (ListView) findViewById( R.id.cr_list ) ;
        _listView.setAdapter( _adapter ) ;


        // response when an item is clicked
        _listView.setClickable(true) ;
        _listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE) ;
    }


    /* --- Submitting Response --------------------------------------------------------------------------------- */

    public void submitResponse( View view )
    {
        int selectedIndex = _listView.getSelectedItemPosition() ;

        if( selectedIndex > -1 )
        {
            //Intent intent = new Intent( this ,   ) ;
            //intent.addExtra( "answer_object" , _answerList.get(selectedIndex) ) ;
            //startActivity( intent ) ;
        }
    }
}