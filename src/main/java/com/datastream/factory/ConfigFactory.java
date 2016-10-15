package com.datastream.factory;

import com.datastream.enums.SocialMediaPlatform;
import com.datastream.utils.Config;
import com.datastream.utils.TwitterConfig;

import java.io.IOException;
import java.util.Properties;

/**
 * Factory class get configs from properties file.
 *
 */
public class ConfigFactory {
    Properties properties = new Properties();

    public Config getConfig(String config){
        if(config == null){
            return null;
        } else if(config.equalsIgnoreCase(SocialMediaPlatform.TWITTER.toString())){
            try {
                properties.load(this.getClass().getResourceAsStream("/twitter4j.properties"));
                return new TwitterConfig(properties.getProperty("oauth.consumerKey"), properties.getProperty("oauth.consumerSecret"), properties.getProperty("oauth.accessToken"), properties.getProperty("oauth.accessTokenSecret"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
