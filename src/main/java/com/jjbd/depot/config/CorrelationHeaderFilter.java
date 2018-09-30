
package com.jjbd.depot.config;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
* CorrelationHeaderFilter
* This filter is to inspect each request header for the presence of Correlation ID
*/
@Component
public class CorrelationHeaderFilter implements Filter {

   private static final Logger LOGGER = LoggerFactory.getLogger(CorrelationHeaderFilter.class);

   @Autowired
   private RequestCorrelation requestCorrelation;

   @Override
   public void init(FilterConfig filterConfig) throws ServletException {

   }

   /*
    * (non-Javadoc)
    *
    * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
    * javax.servlet.ServletResponse, javax.servlet.FilterChain)
    */
   @Override
   public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
           throws IOException, ServletException {

       final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

       String currentCorrId = httpServletRequest.getHeader(requestCorrelation.CORRELATION_ID_HEADER);

       if (currentCorrId == null) {
           currentCorrId = UUID.randomUUID().toString();
           LOGGER.info("No correlationId found in Header. Generated : " + currentCorrId);
       } else {
           LOGGER.info("Found correlationId in Header : " + currentCorrId);
       }

       requestCorrelation.setId(currentCorrId);

       filterChain.doFilter(httpServletRequest, servletResponse);
   }

   @Override
   public void destroy() {
   }

}
