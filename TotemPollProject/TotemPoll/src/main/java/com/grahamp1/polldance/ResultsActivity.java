package com.grahamp1.polldance;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by demouser on 6/12/13.
 */
public class ResultsActivity extends Activity {

    private ListView _listView;
    private ArrayList<String> _listItems = new ArrayList<String>();
    private ArrayAdapter<String> _adapter;

    // maps answer index to number of votes
    private HashMap<Integer, Integer> _votes = new HashMap<Integer, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        _adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, _listItems);
        _listView = (ListView) findViewById(R.id.results_answer_list);
        _listView.setAdapter(_adapter);

        ArrayList<Answer> answers = new ArrayList<Answer>();
        answers.add(new Answer("THIS IS ANSWER ONE", true));
        answers.add(new Answer("answer twoooo", false));
        Question q = new Question("This is the question?", answers);
        setQuestion(q);
    }

    public void setQuestion(Question question) {
        ((TextView) findViewById(R.id.results_question_text)).setText(question.getText());

        for (Answer answer : question.getAnswers()) {
            _listItems.add(answer.getText());
            _adapter.notifyDataSetChanged();
            if (answer.getIsCorrect()) {
                _adapter.getView(_listItems.size() - 1, null, _listView)
                        .setBackgroundColor(Color.GREEN);
            }
        }

    }

    public void addVote(int index) {
        if (_votes.containsKey(index))
            _votes.put(index, _votes.get(index) + 1);
        else
            _votes.put(index, 1);
    }

    public void goToHostHome(View view) {
        startActivity(new Intent(this, HostHomeActivity.class));
    }

}
