package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.androidlibrary.AndroidLibraryActivity;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    // Declare a STRING for the intent extra
    public final static String INTENT_EXTRA = "currentJoke";
    // The progressbar in our view
    ProgressBar progressBar;
    // For the Google advertising
    AdView mAdView;
    // Our joke string
    String joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setGoogleAds();
    }

    public void setGoogleAds(){
        //more or less the function from our example.
        mAdView = (AdView) findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        mAdView.setVisibility(View.GONE);
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
        mAdView.setVisibility(View.VISIBLE);
        try{
            joke = new EndpointsAsyncTask().execute().get();
        }
        catch (ExecutionException e) { e.printStackTrace(); }
        catch (InterruptedException e) { e.printStackTrace(); }
        Intent intent = new Intent(this, AndroidLibraryActivity.class);
        intent.putExtra(INTENT_EXTRA, joke);
        startActivity(intent);
    }
}
