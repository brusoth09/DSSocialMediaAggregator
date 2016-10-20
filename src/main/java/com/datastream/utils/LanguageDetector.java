package com.datastream.utils;

import com.cybozu.labs.langdetect.LangDetectException;
import com.datastream.enums.Language;

/**
 * Detect language of an input.
 */
public interface LanguageDetector {
    Language detectLanguage(String input);
    Boolean languageExist(Language language);
}
