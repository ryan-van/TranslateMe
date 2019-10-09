package org.translateme.app;

import java.util.Scanner;

/**
 * This class is used to handle the translation and pulling from Generator.
 * We use this to pull text from the user and print out the translation for them.
 */
public class Translate {



    protected void start() {
        String inputText = getInput();


    }


    private String getInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter text to be translated");

        return scan.nextLine();
    }
}
