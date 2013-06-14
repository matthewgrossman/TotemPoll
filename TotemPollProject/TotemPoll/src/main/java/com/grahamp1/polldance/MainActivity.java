package com.grahamp1.polldance ;

import android.app.Activity ;
import android.content.Intent ;
import android.os.Bundle ;
import android.view.View ;

import java.util.ArrayList ;


/**
 * Activity for the Splash Screen
 *
 * @author Android Camp 2013, Graham + 1
 * @version 14th June 2013
 */
public class MainActivity extends Activity
{
    /**
     * Initialises the Splash screen.
     *
     * @param savedInstanceState The previous saved state of this activity.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /* --- INTENTS TO ACTIVITIES ------------------------------------------------------------------------------------ */

    /**
     * Starts activity: Shows Host Home Screen
     *
     * @param view The view that invokes this method.
     */
    public void goToHostHome(View view)
    {
        startActivity(new Intent(this, HostHomeActivity.class));
    }
}