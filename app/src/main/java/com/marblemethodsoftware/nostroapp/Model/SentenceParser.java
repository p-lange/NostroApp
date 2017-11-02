package com.marblemethodsoftware.nostroapp.Model;


public class SentenceParser {


    public static String[] getStringArray(String sentence) {
        return sentence.split(
                "(?=[a-z$])(?<=[^a-z$])|(?=[^a-z$])(?<=[a-z$])");
    }
}
