package fr.xebia.clickcount;

import javax.inject.Singleton;

@Singleton
public class Configuration {

    public final String redisHost;
    public final int redisPort;
    public final int redisConnectionTimeout;  //milliseconds

    public Configuration() {
        redisHost = "52.57.107.247";
        redisPort = 6379;
        redisConnectionTimeout = 2000;
    }
}
