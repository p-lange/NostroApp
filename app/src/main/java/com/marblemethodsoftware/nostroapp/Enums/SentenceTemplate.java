package com.marblemethodsoftware.nostroapp.Enums;

public enum SentenceTemplate {

    BAISC("This is a test");


    String template;


    SentenceTemplate (String template){

        this.template = template;
    }

    public String getTemplate(){
        return template;
    }
}
