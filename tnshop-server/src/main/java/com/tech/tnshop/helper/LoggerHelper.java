package com.tech.tnshop.helper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoggerHelper {

    private void loggError(String message) {
        log.error(message);
    }

    private void logInfo(String message) {
        log.info(message);
    }

    private void logWarning(String message) {
        log.warn(message);
    }
}
