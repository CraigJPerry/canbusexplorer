package events;


import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.core.Appender;
import com.craigjperry.canbusexplorer.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Matchers.argThat;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationStartupActionsTest {

    private Logger rootLogger;
    private Appender mockAppender;

    @Before
    public void setUp() {
        rootLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        mockAppender = mock(Appender.class);
        when(mockAppender.getName()).thenReturn("MOCK");
        rootLogger.addAppender(mockAppender);
    }

    @Test
    public void ensureApplicationStartupIsSuitablyFlaggedEverytimeForOpsToSee() {
        verify(mockAppender).doAppend(argThat(new ArgumentMatcher() {
            @Override
            public boolean matches(final Object argument) {
                return ((LoggingEvent) argument).getFormattedMessage().contains("WARN Launching Canbus Explorer on [d1.local] as [craig]");
            }
        }));
    }
}