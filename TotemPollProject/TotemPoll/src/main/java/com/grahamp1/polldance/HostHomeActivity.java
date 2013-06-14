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

    public void goToLoadPoll(View view)
    {
        startActivity( new Intent(this,QuestionSelectionActivity.class) ) ;
    }
}
