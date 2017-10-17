package com.marblemethodsoftware.nostroapp;

import java.util.regex.Pattern;

public class SentenceParser {



    public static String[] getStringArray(String sentence) {

//        String pattern = "(\\s+\\|\\d+\\|\\w+\\|[^\\d\\s\\w])";
        String pattern = "\\s+";
//        String pattern = "\\w+|\\s+";
//        String pattern = "\\w+";

        return sentence.split(pattern);

    }

}
