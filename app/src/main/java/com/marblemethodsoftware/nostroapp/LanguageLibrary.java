package com.marblemethodsoftware.nostroapp;

import android.content.Context;
import com.marblemethodsoftware.nostroapp.Enums.Term;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class LanguageLibrary {

    private Context context;
    private Map<String, String[]> wordLibrary;
    private String[] sentenceLibrary;

    public LanguageLibrary(Context context){
        wordLibrary = new HashMap<>();
        this.context = context;

        for (Term term : Term.values()){
            wordLibrary.put(term.termName, getLibrary(term.termSource, context));
        }
        sentenceLibrary = getLibrary(R.raw.sentencetemplates, context);
    }

    private String[] getLibrary(int id, Context context){

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
        String[] array = wordLibrary.get(term.termName);
        Random rand = new Random();
        int n = rand.nextInt(array.length);
        return array[n];
    }

    public String getRandomSentence(){
        Random rand = new Random();
        int n = rand.nextInt(sentenceLibrary.length);
        return sentenceLibrary[n];
    }
}
