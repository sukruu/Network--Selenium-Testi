package com.network.testlogs;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestResultLogger implements TestWatcher {

    Logger logger = new Logger();
    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName = context.getDisplayName();
        logger.info(testName + " PASSED");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        String testFailCause = cause.getMessage() ;
        logger.error(testName + " FAILED with cause : " + testFailCause);
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {

    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {

    }
}
