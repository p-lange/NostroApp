package com.marblemethodsoftware.nostroapp;


import android.util.Log;
import com.marblemethodsoftware.nostroapp.Enums.Term;


public class Prophecy {

    private String prophecyText;
    private WordLibrary library;


    public Prophecy(int sentenceSeed, WordLibrary library){
        this.library = library;

        prophecyText = sentenceBuilder(sentenceSeed);

    }

    public String getProphecyText(){

        return prophecyText;
    }



    private String sentenceBuilder(int seed){
        String sentence = "the noun that sverb in the season will hardverb";
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




//        if (seed > 15) {
//            seed = 0;
//        }
//
//        switch (seed) {
//            case 0:
//                sentence = library.getRandomWord(Term.ACTION) +
//                        " the " +
//                        library.getRandomWord(Term.ADJECTIVE) + " " +
//                        library.getRandomWord(Term.NOUN) + " " +
//                        library.getRandomWord(Term.ORIGINDESCRIPTION) + " " +
//                        library.getRandomWord(Term.ORIGIN) + ".";
//                break;
//            case 1:
//                sentence = library.getRandomAction() +
//                        " the " +
//                        library.getRandomAdjective() + " " +
//                        library.getRandomNoun() + ", " +
//                        "for when the " +
//                        library.getRandomNoun() + " of the " +
//                        library.getRandomNoun() +
//                        " comes, then the " +
//                        library.getRandomNoun() + " " +
//                        library.getRandomSverb() + ".";
//                break;
//            case 2:
//                sentence = "when the " +
//                        library.getRandomNoun() + " " +
//                        library.getRandomSverb() +
//                        ", then begins the " +
//                        library.getRandomTimePeriod() +
//                        " of the " +
//                        library.getRandomIngVerb() + " " +
//                        library.getRandomNoun() + ".";
//                break;
//            case 3:
//                sentence = "if the " +
//                        library.getRandomNoun() + " " +
//                        library.getRandomSverb() +
//                        ", soon the " +
//                        library.getRandomNoun() + " " +
//                        library.getRandomOriginDescription() + " " +
//                        library.getRandomOrigin() +
//                        " will " +
//                        library.getRandomHardVerb() + ".";
//                break;
//            case 4:
//                sentence = "beware the " +
//                        library.getRandomAdjective() + " " +
//                        library.getRandomNoun() +
//                        " in the " +
//                        library.getRandomTimePeriod() +
//                        " of the " +
//                        library.getRandomNoun() + ".";
//                break;
//            case 5:
//                sentence = "if the " +
//                        library.getRandomNoun() + " " +
//                        library.getRandomSverb() +
//                        ", then you must " +
//                        library.getRandomHardVerb() +
//                        " before the next " +
//                        library.getRandomTimePeriod() + " of the " +
//                        library.getRandomNoun() + ".";
//                break;
//            case 6:
//                sentence = library.getRandomAction() +
//                        " the " +
//                        library.getRandomIngVerb() + " " +
//                        library.getRandomNoun() +
//                        ", for in the " +
//                        library.getRandomTimePeriod() +
//                        " does the " +
//                        library.getRandomNoun() + " " +
//                        library.getRandomHardVerb() + ".";
//                break;
//            case 7:
//                sentence = "when the " +
//                        library.getRandomIngVerb() + " " +
//                        library.getRandomNoun() + " " +
//                        library.getRandomSverb() +
//                        ", then the " +
//                        library.getRandomNoun() + " must " +
//                        library.getRandomHardVerb() + ".";
//                break;
//            case 8:
//                sentence = library.getRandomAdjective() +
//                        " is the " +
//                        library.getRandomNoun() +
//                        " that is not " +
//                        library.getRandomIngVerb() + ".";
//            case 9:
//                sentence = library.getRandomAdjective() +
//                        " is the " +
//                        library.getRandomNoun() +
//                        " that " +
//                        library.getRandomSverb() + ".";
//            case 10:
//                sentence = "if the " +
//                        library.getRandomNoun() + " " +
//                        library.getRandomSverb() +
//                        ", then the " +
//                        library.getRandomAdjective() + " " +
//                        library.getRandomNoun() +
//                        " must " +
//                        library.getRandomHardVerb() +
//                        " before the next " +
//                        library.getRandomTimePeriod() + " of the " +
//                        library.getRandomNoun() +
//                        ", or the " +
//                        library.getRandomNoun() + " shall never again " +
//                        library.getRandomHardVerb() + ".";
//                break;
//            case 11:
//                sentence = "the " +
//                        library.getRandomIngVerb() + " " +
//                        library.getRandomNoun() +
//                        " will be no more.";
//                break;
//            case 12:
//                sentence = library.getRandomAction() +
//                        " the " +
//                        library.getRandomIngVerb() + " " +
//                        library.getRandomNoun() + ".";
//                break;
//
//            case 13:
//                sentence = "you must use the " +
//                        library.getRandomWeapon() +
//                        " to " +
//                        library.getRandomAction() + " " +
//                        library.getRandomPluralNoun() + ".";
//                break;
//
//            case 14:
//                sentence = "take heed when the " +
//                        library.getRandomPluralNoun() + " " +
//                        library.getRandomHardVerb()+ ". Then will the "+
//                        library.getRandomTimePeriod() + " of " +
//                        library.getRandomAdjective() + " " +
//                        library.getRandomPluralNoun() + " begin.";
//                break;
//
//            case 15:
//                sentence = " only by the " +
//                        library.getRandomAdjective() + " " +
//                        library.getRandomWeapon() + " can the " +
//                        library.getRandomAdjective() + " " +
//                        library.getRandomNoun() +
//                        library.getRandomHardVerb();
//                break;
//        }

        return prophecy;
    }


}
