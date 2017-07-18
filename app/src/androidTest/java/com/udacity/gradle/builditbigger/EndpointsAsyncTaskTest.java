package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.JokeTelling;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;



/**
 * Created by bjoern on 17.07.17.
 *
 * @author <a href="mailto:mail@bjoern.cologne">Bjoern Gam</a>
 * @link <a href="http://bjoern.cologne">Webpage </a>
 * <p>
 * Description:
 */


@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    @Test
    public void testVerifyJoke() throws InterruptedException {

        String myJoke = " ";

        try {
            myJoke = new EndpointsAsyncTask().execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        // Checking if the result is empty or NULL
        assertTrue(myJoke, myJoke != null);
        assertTrue(myJoke, !myJoke.isEmpty());

        JokeTelling jokes = new JokeTelling();
        // Compare the result String with our given jokes
        assertThat(myJoke, CoreMatchers.anyOf(
                CoreMatchers.containsString(jokes.firstJoke),
                CoreMatchers.containsString(jokes.secondJoke),
                CoreMatchers.containsString(jokes.thirdJoke)));
    }
}