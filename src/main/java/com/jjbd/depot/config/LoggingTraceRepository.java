
package com.jjbd.depot.config;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.InMemoryTraceRepository;
import org.springframework.boot.actuate.trace.Trace;
import org.springframework.boot.actuate.trace.TraceRepository;
import org.springframework.stereotype.Component;

/**
* Logging Trace Repository
*/
@Component
public class LoggingTraceRepository implements TraceRepository {

	private static final Logger LOG = LoggerFactory.getLogger(LoggingTraceRepository.class);
	private final TraceRepository delegate = new InMemoryTraceRepository();

	@Autowired
	private RequestCorrelation requestCorrelation;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.boot.actuate.trace.TraceRepository#findAll()
	 */
	@Override
	public List<Trace> findAll() {
		return delegate.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.boot.actuate.trace.TraceRepository#add(java.util.Map)
	 */
	@Override
	public void add(Map<String, Object> traceInfo) {
		JSONObject traceObj = new JSONObject();
		try {
			traceObj.put("correlationId", requestCorrelation.getId());
			traceObj.put("method", traceInfo.get("method"));
			traceObj.put("path", traceInfo.get("path"));
			traceObj.put("host", ((Map) ((Map) traceInfo.get("headers")).get("request")).get("host"));
			traceObj.put("status", ((Map) ((Map) traceInfo.get("headers")).get("response")).get("status"));
			traceObj.put("timeTaken", traceInfo.get("timeTaken"));
			LOG.info(traceObj.toString());
			this.delegate.add(traceInfo);
		} catch (JSONException e) {
			LOG.error(e.toString());
			e.printStackTrace();
		}
	}

}