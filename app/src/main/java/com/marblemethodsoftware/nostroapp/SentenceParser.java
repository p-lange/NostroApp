package com.marblemethodsoftware.nostroapp;

import java.util.regex.Pattern;

public class SentenceParser {


    public static String[] getStringArray(String sentence) {

        String pattern = "\\s+";

        return sentence.split(pattern);

    }

}
