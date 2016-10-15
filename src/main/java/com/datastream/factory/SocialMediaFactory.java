package com.datastream.factory;

import com.datastream.enums.SocialMediaPlatform;
import com.datastream.socialmedia.SocialMedia;
import com.datastream.socialmediaImpl.SMTwitter;
import com.datastream.utils.TwitterConfig;

/**
 * Factory class for get social media
 *
 */
public class SocialMediaFactory {

    public SocialMedia getSocialMedia(String name) {
        if(name == null){
            return null;
        } else if(name.equalsIgnoreCase(SocialMediaPlatform.TWITTER.toString())){
            return new SMTwitter((TwitterConfig) new ConfigFactory().getConfig(SocialMediaPlatform.TWITTER.toString()));
        }
        return null;
    }
}
