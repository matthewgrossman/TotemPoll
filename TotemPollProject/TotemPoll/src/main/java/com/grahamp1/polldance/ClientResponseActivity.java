package com.grahamp1.polldance ;

import android.app.Activity ;
import android.os.Bundle ;

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
    private String[] _answerList ;

    // Selected answer
    private int _selected ;


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
        _answerList = question.getAnswerList() ;
        _selected = -1 ;

        // add the question to the screen
        TextView questionView = (TextView) findViewById( R.id.cr_question ) ;
        questionView.setText( question.getText() ) ;


        // load the answers to the ListView
        _adapter = new ArrayAdapter<String>( this , android.R.layout.simple_list_item_single_choice , _answerList ) ;

        final ListView listView = (ListView) findViewById( R.id.cr_list ) ;
        listView.setAdapter( _adapter ) ;


        // response when an item is clicked
        listView.setClickable(true) ;
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE) ;
        _selected = listView.getSelectedItemPosition() ;
    }


    /**
     * Returns the selected answer.
     *
     * @return The selected answer.
     */
    public int getSelectedAnswer()
    {
        return _selected ;
    }
}