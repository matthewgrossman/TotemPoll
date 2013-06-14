package com.grahamp1.polldance ;

import android.app.Activity ;
import android.content.Intent;
import android.os.Bundle ;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter ;
import android.widget.ListView ;
import android.widget.TextView ;
import android.widget.Toast;

import java.util.ArrayList ;
import java.util.Arrays;
import java.util.List;

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
    int[] responses;
    Question question;


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
        question = (Question) getIntent().getSerializableExtra( "question_object" ) ;
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
        responses = new int[_answerList.size()];

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
        int selectedIndex = _listView.getCheckedItemPosition() ;
        responses[selectedIndex]++;
        _listView.setItemChecked(selectedIndex,false);
        Toast.makeText(this,"You selected: " + _answerList.get(selectedIndex).getText() + "\n" + "Please pass the device", Toast.LENGTH_SHORT).show();
    }

    public void showResults(View view){

        Intent intent = new Intent(this,ResultsActivity.class);
        intent.putExtra("answer_list", _answerList);
        intent.putExtra("scores_list", responses);
        intent.putExtra("question_name", question.getText());

        startActivity(intent);

    }
}