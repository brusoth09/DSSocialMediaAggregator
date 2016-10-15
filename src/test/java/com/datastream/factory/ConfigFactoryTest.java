package com.datastream.factory;

import com.datastream.enums.SocialMediaPlatform;
import com.datastream.utils.Config;
import com.datastream.utils.TwitterConfig;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Testing class for Config Factory
 *
 */
public class ConfigFactoryTest {
    @Test
    public void testConfigTest(){
        ConfigFactory configFactory = new ConfigFactory();
        Config config = configFactory.getConfig(SocialMediaPlatform.TWITTER.toString());
        assertTrue(config instanceof TwitterConfig);
    }
}
