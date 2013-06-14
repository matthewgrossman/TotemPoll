package com.grahamp1.polldance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by demouser on 6/12/13.
 */
public class HostHomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_home);

    }

    public void goToCreatePoll(View view) {
        startActivity(new Intent(HostHomeActivity.this, CreatePollActivity.class));
    }

    public void goToLoadPoll(View view){
        ArrayList <Question> questions = importXmlQuestions();
        Intent intent = new Intent(HostHomeActivity.this,HostLoadActivity.class);
        Bundle b = new Bundle();
    }

    public String getXmlString(){
        InputStream stream = getResources().openRawResource(R.raw.questions);
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader buffRead = new BufferedReader(streamReader);
        StringBuilder builder  = new StringBuilder();
        String line;

        try {
            while ((line = buffRead.readLine()) != null) {
                builder.append(line + "\n");
            }
        } catch (IOException e) {}
        return builder.toString();
    }

    ArrayList<Question> importXmlQuestions(){
        XMLParser parser = new XMLParser();
        ArrayList <Question> ret = new ArrayList<Question>();

        try {
            ret = parser.getQuestions(getXmlString());
        } catch (Exception e){}
        return ret;

    }

}
