package com.marblemethodsoftware.nostroapp;

import java.util.regex.Pattern;

public class SentenceParser {


    public static String[] getStringArray(String sentence) {
    //TODO: Fix this REGEX to keep spaces and punctuation.
        String pattern = "\\s+";

        return sentence.split(pattern);

    }

}
