package com.marblemethodsoftware.nostroapp;


import android.util.Log;
import com.marblemethodsoftware.nostroapp.Enums.Term;

import java.util.Random;


public class Prophecy {

    private String prophecyText;
    private LanguageLibrary library;


    public Prophecy(LanguageLibrary library){
        this.library = library;

        prophecyText = sentenceBuilder(library.getRandomSentence());

    }

    public String getProphecyText(){

        return prophecyText;
    }

    private String sentenceBuilder(String sentence){
        String[] words = SentenceParser.getStringArray(sentence);
        String prophecy = "";
        for (String word : words){
            for (Term term : Term.values()){
                if (word.equals(term.termName)){
                    word = library.getRandomWord(term);
                    Log.d("TAG", "Got a HIT!");
                }
            }
            prophecy += word + " ";
            Log.d("TAG", "Did not get HIT!");
        }

        return prophecy;
    }

}
