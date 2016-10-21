package com.datastream.utils;

import com.cybozu.labs.langdetect.LangDetectException;
import com.datastream.enums.Language;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Google language detection class testing
 *
 */
public class GoogleLanguageDetectorTest {
    private static GoogleLanguageDetector googleLanguageDetector = new GoogleLanguageDetector();
    public static boolean initialized = false;


    @Test
    public void checkLanguageExist() throws LangDetectException {
        assertTrue(new GoogleLanguageDetector().languageExist(Language.ENGLISH));
    }

    @Test
    public void testEnglishLanguageDetection() throws LangDetectException {
        assertTrue(googleLanguageDetector.detectLanguage("This is English").compareTo(Language.ENGLISH) == 0);
    }

    @Test
    public void testNonEnglishLanguageDetection() throws LangDetectException {
        assertNull(googleLanguageDetector.detectLanguage("靠！我电脑坏了！"));

    }
}
