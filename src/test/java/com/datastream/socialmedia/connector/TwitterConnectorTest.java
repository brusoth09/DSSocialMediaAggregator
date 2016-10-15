package com.datastream.socialmedia.connector;

import com.datastream.enums.SocialMediaPlatform;
import com.datastream.factory.ConfigFactory;
import com.datastream.socialmedia.SocialMedia;
import com.datastream.factory.SocialMediaFactory;
import com.datastream.socialmediaImpl.SMTwitter;
import com.datastream.utils.TwitterConfig;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * This class is used to test the twitter connection
 *
 */
public class TwitterConnectorTest{
    private static final String twitter = "TWITTER";
    @Test
    public void connectTwitterAPITest(){
        SocialMediaFactory factory = mock(SocialMediaFactory.class);
        when(factory.getSocialMedia(twitter)).thenReturn(new SMTwitter((TwitterConfig) new ConfigFactory().getConfig(SocialMediaPlatform.TWITTER.toString())));
        SocialMedia socialMedia = factory.getSocialMedia(twitter);
        socialMedia.connect();
    }
}
