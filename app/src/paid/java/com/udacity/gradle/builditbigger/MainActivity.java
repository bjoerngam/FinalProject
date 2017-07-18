package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.udacity.gradle.androidlibrary.AndroidLibraryActivity;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    // Declare a STRING for the intent extra
    public final static String INTENT_EXTRA = "currentJoke";

    // The progress bar in the current view
    ProgressBar progressBar;

    String joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        progressBar = (ProgressBar) findViewById(R.id.pbLoader);
        progressBar.setVisibility(View.GONE);
        try {
            joke = new EndpointsAsyncTask().execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent(this, AndroidLibraryActivity.class);
        intent.putExtra(INTENT_EXTRA, joke);
        startActivity(intent);
    }
}