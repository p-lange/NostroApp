package com.marblemethodsoftware.nostroapp;

import com.marblemethodsoftware.nostroapp.Enums.Term;

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
        StringBuilder builder = new StringBuilder();

        for (String word : words){
            for (Term term : Term.values()){
                if (word.equals(term.termName)){
                    word = library.getRandomWord(term);
                }
            }
            builder.append(word);
        }
        return builder.toString().substring(0, 1).toUpperCase() + builder.toString().substring(1);
    }

}
