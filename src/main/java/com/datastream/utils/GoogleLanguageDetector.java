package com.datastream.utils;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;
import com.datastream.enums.Language;

import java.util.ArrayList;

/**
 * This class is used to identify language of a text.
 *
 */
public class GoogleLanguageDetector implements LanguageDetector {

    private static Detector detector;

    static{
        String path=System.getProperty("user.dir")+"/src/main/resources/profiles/";
        System.out.println(path);
        try {
            DetectorFactory.loadProfile(path);
        } catch (LangDetectException e) {
            e.printStackTrace();
        }
    }

    public Language detectLanguage(String input) {
        try {
            detector = DetectorFactory.create();
            detector.append(input);
            ArrayList<com.cybozu.labs.langdetect.Language> langlist = detector.getProbabilities();
            for(com.cybozu.labs.langdetect.Language lan:langlist)
            {
                if(lan.lang.equalsIgnoreCase("en") && lan.prob>0.8)
                {
                    return Language.ENGLISH;
                }
            }

        } catch (LangDetectException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Boolean languageExist(Language language) {
        return true;
    }
}
