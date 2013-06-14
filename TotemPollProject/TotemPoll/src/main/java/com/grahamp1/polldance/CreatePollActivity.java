package com.grahamp1.polldance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by demouser on 6/12/13.
 */
public class CreatePollActivity extends Activity {

    ArrayList<String> _listItems = new ArrayList<String>();
    ArrayAdapter<String> _adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_poll);

        findViewById(R.id.create_answer_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new NewAnswerDialogFragment().show(getFragmentManager(), "create_answer_dialog");
            }
        });

        findViewById(R.id.share_poll_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreatePollActivity.this, ClientResponseActivity.class);

                // get question and answer text from form
                String questionHtml = Html.toHtml(
                        ((EditText) findViewById(R.id.create_question_text)).getText()
                );
                ArrayList<Answer> answers = new ArrayList<Answer>();
                for (String s : _listItems)
                    answers.add(new Answer(s, false));
                Question q = new Question(questionHtml, answers);

                // pass data to ClientResponseActivity
                intent.putExtra( "question_object" , q ) ;
                startActivity( intent ) ;

            }
        });

        findViewById(R.id.add_hyperlink_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddHyperlinkFragment().show(getFragmentManager(), "hyperlink_dialog");
            }
        });

        _adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, _listItems);
        final ListView lv = (ListView) findViewById(R.id.create_answer_list);
        lv.setAdapter(_adapter);

        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                new EditAnswerDialogFragment(i, _listItems.get(i)).show(
                        getFragmentManager(), "dialog"
                );
            }
        });

        EditText questionText = ((EditText) findViewById(R.id.create_question_text));
        questionText.setMovementMethod(LinkMovementMethod.getInstance());

    }

    public void createNewAnswer(String answerText) {
        if (!answerText.trim().equals("")) {
            _listItems.add(answerText);
            _adapter.notifyDataSetChanged();
        }
    }

    public void editAnswerText(int i, String newAnswerText) {
        _listItems.set(i, newAnswerText);
        _adapter.notifyDataSetChanged();
    }

}
