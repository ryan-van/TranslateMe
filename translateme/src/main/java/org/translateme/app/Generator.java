package org.translateme.app;

import java.util.Map;
import java.util.Random;

public class Generator {

    // Random import for random number generator
    private Random rand = new Random();

    private Languages languages = new Languages();

    // Returns a random language code
    private String randomLanguage() {
        Map<String, String> lan = languages.getCodeToLanguage();
        int n = lan.size();

        rand.nextInt(n);
        return lan.get("en");
    }
}
