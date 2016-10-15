package com.datastream.factory;

import com.datastream.enums.SocialMediaPlatform;
import com.datastream.socialmedia.SocialMedia;
import com.datastream.socialmediaImpl.SMTwitter;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * test class social media factory
 *
 */
public class SocialMediaFactoryTest {

    @Test
    public void getSocialMediaTest(){
        SocialMediaFactory socialMediaFactory = new SocialMediaFactory();
        SocialMedia twitter = socialMediaFactory.getSocialMedia(SocialMediaPlatform.TWITTER.toString());
        assertTrue(twitter instanceof SMTwitter);
    }
}
