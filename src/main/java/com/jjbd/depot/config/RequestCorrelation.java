
package com.jjbd.depot.config;

import org.springframework.stereotype.Component;

/**
 * RequestCorrelation
 * This is the entity to hold the correlation id for the current Thread
 */
@Component
public class RequestCorrelation {

    public final String CORRELATION_ID_HEADER = "correlationId";

    private final ThreadLocal<String> id = new ThreadLocal<String>();

    public void setId(String correlationId) {
        id.set(correlationId);
    }

    public String getId() {
        return id.get();
    }
}
