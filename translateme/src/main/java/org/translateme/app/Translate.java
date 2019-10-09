package org.translateme.app;

import com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazonaws.auth.EnvironmentVariableCredentialsProvider;
import com.amazonaws.auth.SystemPropertiesCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.AmazonTranslateClient;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;

import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * This class is used to handle the translation and pulling from Generator.
 * We use this to pull text from the user and print out the translation for them.
 */
public class Translate {

    // Use the only available server close to me
    private static String region = "us-west-2";
    private Languages language = new Languages();


    protected void start() {
        String text = getInput();
        String originalText = text;

        // Start with English
        String beginLanguage = "en";
        int timesTranslated = 9;
        List<String> targets = randomList(timesTranslated);
        // End with English
        targets.add("en");

        // Create credentials using a provider chain that will evaluate in order;
        // a) Any Java system properties
        // b) Any environment variables
        // c) Any profile file
        AWSCredentialsProviderChain DefaultAWSCredentialsProviderChain = new AWSCredentialsProviderChain(
                new SystemPropertiesCredentialsProvider(),
                new EnvironmentVariableCredentialsProvider(),
                new ProfileCredentialsProvider()
        );

        // Create an Amazon Translate client
        AmazonTranslate translate = AmazonTranslateClient.builder()
                .withCredentials(DefaultAWSCredentialsProviderChain)
                .withRegion(region)
                .build();

        for (String target: targets) {
            TranslateTextRequest request = new TranslateTextRequest()
                    .withText(text)
                    .withSourceLanguageCode(beginLanguage)
                    .withTargetLanguageCode(target);
            TranslateTextResult result = translate.translateText(request);
            beginLanguage = target;
            text = result.getTranslatedText();
        }

        Map<String, String> allLanguages = language.getCodeToLanguage();

        System.out.println("Original text: " + originalText);
        System.out.println("Your text was translated " + timesTranslated + " times.");
        System.out.print("Your text was translated from " + beginLanguage + " to ");
        for (int i = 0; i < targets.size() - 1; i++) {
            System.out.print(allLanguages.get(targets.get(i)) + " ");
        }
        System.out.println();
        System.out.println("Translated text: " + text);
    }

    private String getInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter text to be translated");

        return scan.nextLine();
    }

    // temporarily use a arraylist, will probably change to hashset for faster lookup times
    private List<String> randomList(int times) {
        assert times < 34;
        Generator generator = new Generator();
        List<String> listLanguages = new ArrayList<>();
        while (listLanguages.size() != times) {
            String lan = generator.randomLanguage();
            if (!listLanguages.contains(lan)) {
                listLanguages.add(lan);
            }
        }

        return listLanguages;
    }
}