package com.marblemethodsoftware.nostroapp.Enums;

import com.marblemethodsoftware.nostroapp.R;

public enum Term {


    ACTION("action", R.raw.actions),
    ADJECTIVE("adjective", R.raw.adjectives),
    COLOR("color", R.raw.colors),
    HARDVERB("hardverb", R.raw.hardverbs),
    INGVERB("ingverb", R.raw.ingverbs),
    NOUN("noun", R.raw.nouns),
    ORIGINDESCRIPTION("origindescription", R.raw.origindescriptions),
    ORIGIN("origin", R.raw.origins),
    PLURALNOUN("pluralnoun", R.raw.pluralnouns),
    SVERB("sverb", R.raw.sverbs),
    TIMEPERIOD("timeperiod", R.raw.timeperiods),
    WEAPON("weapon", R.raw.weapons);

    public String termName;
    public int termSource;
    public String[] termList;

     Term (String name, int rawSource){

         termName = name;
         termSource = rawSource;

     }


}
