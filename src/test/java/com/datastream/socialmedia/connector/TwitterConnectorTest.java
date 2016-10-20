package com.datastream.socialmedia.connector;

import com.datastream.enums.Language;
import com.datastream.enums.SocialMediaPlatform;
import com.datastream.factory.ConfigFactory;
import com.datastream.factory.SocialMediaFactory;
import com.datastream.socialmedia.SocialMedia;
import com.datastream.socialmediaImpl.SMTwitter;
import com.datastream.utils.TwitterConfig;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import twitter4j.Trend;
import twitter4j.Trends;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * This class is used to test the twitter connection
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TwitterConnectorTest{
    private static final String twitter = "TWITTER";
    private SocialMedia socialMedia;

    @Before
    public void initializeTwitter(){
        SocialMediaFactory factory = mock(SocialMediaFactory.class);
        when(factory.getSocialMedia(twitter)).thenReturn(new SMTwitter((TwitterConfig) new ConfigFactory().getConfig(SocialMediaPlatform.TWITTER.toString())));
        socialMedia = factory.getSocialMedia(twitter);
    }

    @Test
    public void connectTwitterAPITest(){
        socialMedia.connect();
    }

    @Test
    public void getPlaceTrendsTestGlobal() throws Exception {
        socialMedia.connect();
        Trends trends = socialMedia.getTrendsByLocationID(1);
        assertTrue(trends.getTrends().length > 0);
    }

    @Test
    public void getPlaceTrendsByLanguage(){
        socialMedia.connect();
        Trends trends = socialMedia.getTrendsByLocationAndLanguage(1, Language.ENGLISH);
    }
}
