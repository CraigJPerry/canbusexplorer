package com.craigjperry.canbusexplorer.events;

import com.craigjperry.canbusexplorer.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.contentOf;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationStartupActionsTest {

    @Value("${logging.file}")
    private String loggingFile;

    @Test
    public void ensureApplicationStartupIsSuitablyFlaggedEverytimeSoThatOpsAreAware() throws IOException {
        assertThat(contentOf(new File(loggingFile))).contains("Launching Canbus Explorer on [");
    }

}
