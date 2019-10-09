package org.translateme.app;

import java.util.HashMap;
import java.util.Map;

public class Languages {

    // HashMap to map language to language code.
    private static Map<String, String> codeToLangauge = new HashMap<>() {{
        put("ar", "Arabic");
        put("zh", "Chinese (Simplified)");
        put("zh-TW", "Chinese (Traditional)");
        put("cs", "Czech");
        put("da", "Danish");
        put("nl", "Dutch");
        put("en", "English");
        put("fi", "Finnish");
        put("fr", "French");
        put("de", "German");
        put("el", "Greek");
        put("he", "Hebrew");
        put("hi", "Hindi");
        put("hu", "Hungarian");
        put("id", "Indonesian");
        put("it", "Italian");
        put("ja", "Japanese");
        put("ko", "Korean");
        put("ms", "Malay");
        put("no", "Norwegian");
        put("fa", "Persian");
        put("pl", "Polish");
        put("pt", "Portuguese");
        put("ro", "Romanian");
        put("ru", "Russian");
        put("es", "Spanish");
        put("sv", "Swedish");
        put("th", "Thai");
        put("tr", "Turkish");
        put("uk", "Ukrainian");
        put("ur", "Urdu");
        put("vi", "Vietnamese");
    }};

    private static Map<String, String> languageToCode = new HashMap<>() {{
        put("Arabic", "ar");
        put("Chinese (Simplified)","zh");
        put("Chinese (Traditional)", "zh-TW");
        put("Czech", "cs");
        put("Danish", "da");
        put("Dutch", "nl");
        put("English", "en");
        put("Finnish", "fi");
        put("French", "fr");
        put("German","de");
        put("Greek", "el");
        put("Hebrew", "he");
        put("Hindi", "hi");
        put("Hungarian", "hu");
        put("Indonesian", "id");
        put("Italian", "it");
        put("Japanese", "ja");
        put("Korean", "ko");
        put("Malay", "ms");
        put("Norwegian", "no");
        put("Persian", "fa");
        put("Polish", "pl");
        put("Portuguese", "pt");
        put("Romanian", "ro");
        put("Russian","ru");
        put("Spanish", "es");
        put("Swedish", "sv");
        put("Thai", "th");
        put("Turkish", "tr");
        put("Ukrainian", "uk");
        put("Urdu", "ur");
        put("Vietnamese", "vi");
    }};

    // Return HashMap for language to lan code
    protected Map<String, String> getLanguageToCode() {
        return languageToCode;
    }

    // Return HashMap for lan code to language
    protected Map<String, String> getCodeToLanguage() {
        return codeToLangauge;
    }
}
