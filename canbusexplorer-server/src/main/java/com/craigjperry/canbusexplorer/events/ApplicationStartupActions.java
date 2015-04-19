package com.craigjperry.canbusexplorer.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupActions implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private String hostname;

    @Value("#{systemProperties['user.name']}")
    private String username;

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        LOG.warn("Launching Canbus Explorer on [{}] as [{}]", hostname, username);
    }

}
