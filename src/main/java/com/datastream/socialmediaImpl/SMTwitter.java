package com.datastream.socialmediaImpl;

import com.datastream.socialmedia.SocialMedia;
import com.datastream.utils.Config;
import com.datastream.utils.TwitterConfig;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 */
public class SMTwitter implements SocialMedia{

    private TwitterConfig config;
    private Twitter twitter;

    public SMTwitter(TwitterConfig twitter){
        this.config = twitter;
    }

    public void connect() {
        twitter = new TwitterFactory(createConfiguration()).getInstance();
    }

    private Configuration createConfiguration(){
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(config.getConsumerKey())
                .setOAuthConsumerSecret(config.getConsumerSecret())
                .setOAuthAccessToken(config.getConsumerKey())
                .setOAuthAccessTokenSecret(config.getAccessTokenSecret());
        return cb.build();
    }
}
