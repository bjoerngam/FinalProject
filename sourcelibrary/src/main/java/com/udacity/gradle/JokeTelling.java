package com.udacity.gradle;

import java.util.ArrayList;

public class JokeTelling {

    // Jokes from: http://onelinefun.com/it/

    public String firstJoke
            = "How do two programmers make money? One writes viruses, the other anti-viruses.";

    public String secondJoke
            = "I changed my password to incorrect So whenever I forget what it is the computer will say Your password is incorrect.";

    public String thirdJoke
            = "It's ok computer, I go to sleep after 20 minutes of inactivity too.";

    private ArrayList<String> jokes;

    public JokeTelling() {
        jokes = new ArrayList<>();
        jokes.add(firstJoke);
        jokes.add(secondJoke);
        jokes.add(thirdJoke);
    }

    public String getJokes(int position) { return jokes.get(position);}

}