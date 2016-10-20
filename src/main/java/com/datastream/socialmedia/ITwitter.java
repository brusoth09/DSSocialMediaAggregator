package com.datastream.socialmedia;

import com.datastream.enums.Language;
import twitter4j.Trends;

/**
 * Created by aburu on 10/20/2016.
 */
public interface ITwitter {
    Trends getTrendsByLocationID(int locationID) throws Exception;

    Trends getTrendsByLocationAndLanguage(int i, Language english);
}
