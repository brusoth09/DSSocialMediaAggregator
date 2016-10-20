package com.datastream.socialmediaImpl;

import com.datastream.enums.Language;
import com.datastream.socialmedia.SocialMedia;
import com.datastream.utils.GoogleLanguageDetector;
import com.datastream.utils.LanguageDetector;
import com.datastream.utils.TwitterConfig;
import twitter4j.*;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class SMTwitter implements SocialMedia{

    private TwitterConfig config;
    private Twitter twitter;

    public SMTwitter(TwitterConfig twitter){
        this.config = twitter;
    }

    public void connect(){
        twitter = new TwitterFactory(createConfiguration()).getInstance();
    }

    public Trends getTrendsByLocationID(int locationID) throws TwitterException {
        return twitter.getPlaceTrends(locationID);
    }

    public List<Trend> getTrendsByLocationAndLanguage(int i, Language lang) throws TwitterException {
        Trends trends = getTrendsByLocationID(i);
        List<Trend> trending = new ArrayList<Trend>();
        LanguageDetector detector = new GoogleLanguageDetector();
        for(Trend trend:trends.getTrends()){
            if(detector.detectLanguage(trend.getName()) != null && detector.detectLanguage(trend.getName()).compareTo(Language.ENGLISH) == 0){
                trending.add(trend);
            }
        }
        return trending;
    }

    private Configuration createConfiguration(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(config.getConsumerKey())
                .setOAuthConsumerSecret(config.getConsumerSecret())
                .setOAuthAccessToken(config.getAccessToken())
                .setOAuthAccessTokenSecret(config.getAccessTokenSecret());
        return cb.build();
    }

}
