package com.datastream.socialmedia;

import com.datastream.enums.Language;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.TwitterException;

import java.util.List;

/**
 * Created by aburu on 10/20/2016.
 */
public interface ITwitter {
    Trends getTrendsByLocationID(int locationID) throws Exception;

    List<Trend> getTrendsByLocationAndLanguage(int i, Language english) throws TwitterException;
}
