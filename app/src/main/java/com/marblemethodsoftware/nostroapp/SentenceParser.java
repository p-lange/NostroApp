package com.marblemethodsoftware.nostroapp;

public class SentenceParser {



    public static String[] getStringArray(String sentence){

        String[] words = sentence.split("\\s+");

        return words;

    }


}
