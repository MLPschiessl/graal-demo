package service.profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfileLoggerLocal implements ProfileLogger {

    private static final Logger LOG = LoggerFactory.getLogger(ProfileLoggerLocal.class);

    @Override
    public void logEvent() {
        LOG.info("This action uses the profile context 'local'.");
    }
}
