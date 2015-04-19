package com.craigjperry.canbusexplorer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class RuntimeEnvironment {
    @Bean
    public String hostname() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }
}
