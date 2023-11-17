package service.profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfileLoggerOther implements ProfileLogger {

    private static final Logger LOG = LoggerFactory.getLogger(ProfileLoggerOther.class);

    @Override
    public void logEvent() {
        LOG.info("This action uses another profile context than 'local'.");
    }
}
