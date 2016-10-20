package com.datastream.enums;

/**
 * Created by aburu on 10/20/2016.
 */
public enum Language {
    ENGLISH("en");

    private String lang;

    Language(String lang){
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }
}
