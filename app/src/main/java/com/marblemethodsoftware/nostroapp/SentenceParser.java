package com.marblemethodsoftware.nostroapp;


public class SentenceParser {


    public static String[] getStringArray(String sentence) {
        return sentence.split(
                "(?=[X])(?<=[^X])|(?=[^X])(?<=[X])".replace("X", "a-z$"));
    }
}
