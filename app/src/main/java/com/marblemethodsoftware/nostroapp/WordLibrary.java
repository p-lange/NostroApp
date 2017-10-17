package com.marblemethodsoftware.nostroapp;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class WordLibrary {

    private String[] nouns;
    private String[] weapons;
    private String[] actions;
    private String[] hardVerbs;
    private String[] ingVerbs;
    private String[] origins;
    private String[] originDescriptions;
    private String[] adjectives;
    private String[] sVerbs;
    private String[] timePeriods;
    private String[] pluralNouns;

    private Context context;
    private Map<String, String[]> library;

    public WordLibrary(Context context){
        //build all the world libraries
        this.context = context;

        for (Term term : Term.values()){
            library.put(term.termName, buildLibrary(term.termSource, context));
        }
    }

    private String[] buildLibrary(int id, Context context){

        InputStream stream = context.getResources().openRawResource(id);
        InputStreamReader inputReader = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(inputReader);

        String string;
        List<String> list = new ArrayList<>();
        try {
            while ((string = reader.readLine()) != null) {
                list.add(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list.toArray(new String[0]);
    }

    public String getRandomWord(Term term){
        String[] array = library.get(term.termName);
        Random rand = new Random();
        int n = rand.nextInt(array.length);
        return array[n];
    }

}
