package org.translateme.app;

import java.util.Map;
import java.util.Random;

public class Generator {

    // Random import for random number generator
    private Random rand = new Random();

    private Languages languages = new Languages();

    // Returns a random language code
    protected String randomLanguage() {
        Map<String, String> lan = languages.getCodeToLanguage();
        int n = lan.size();

        Object[] values = lan.keySet().toArray();
        int randIndex = rand.nextInt(n);

        return (String) values[randIndex];
    }
}
