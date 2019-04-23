package com.bighalf.customers.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.glassfish.jersey.message.internal.ReaderWriter;

public class CustomLoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {
    @Context
    private ResourceInfo resourceInfo;

    private static final Logger log = Logger.getLogger(CustomLoggingFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        //Note down the start request time...we will use to calculate the total
        //execution time
        MDC.put("start-time", String.valueOf(System.currentTimeMillis()));

        log.debug("\n\n\n\n\n\n\nEntering in Resource : /{} "+ requestContext.getUriInfo().getPath());
        log.debug("\n\n\nMethod Name : {} "+ resourceInfo.getResourceMethod().getName());
        log.debug("\n\n\nClass : {} "+ resourceInfo.getResourceClass().getCanonicalName());
        logQueryParameters(requestContext);
        logMethodAnnotations();
        logRequestHeader(requestContext);

        //log entity stream...
        String entity = readEntityStream(requestContext);
        if(null != entity && entity.trim().length() > 0) {
            log.debug("Entity Stream : {}"+ entity);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("User: ").append(requestContext.getSecurityContext().getUserPrincipal() == null ? "unknown"
                        : requestContext.getSecurityContext().getUserPrincipal());
        sb.append(" - Path: ").append(requestContext.getUriInfo().getPath());
        sb.append(" - Header: ").append(requestContext.getHeaders());
        sb.append(" - Entity: ").append(entity);
        log.debug("\n\n\nHTTP REQUEST : " + sb.toString());
    }

	private void logQueryParameters(ContainerRequestContext requestContext) {
        Iterator<String> iterator = requestContext.getUriInfo().getPathParameters().keySet().iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            List<String> obj = requestContext.getUriInfo().getPathParameters().get(name);
            String value = null;
            if(null != obj && obj.size() > 0) {
                value = obj.get(0);
            }
            log.debug("\n\nQuery Parameter Name: {}, Value :{}" +  name+"," +value);
        }
    }

    private void logMethodAnnotations() {
        Annotation[] annotations = resourceInfo.getResourceMethod().getDeclaredAnnotations();
        if (annotations != null && annotations.length > 0) {
            log.debug("\n\n\n----Start Annotations of resource ----");
            for (Annotation annotation : annotations) {
                log.debug(annotation.toString());
            }
            log.debug("----End Annotations of resource----");
        }
    }

    private void logRequestHeader(ContainerRequestContext requestContext) {
        Iterator<String> iterator;
        log.debug("\n\n\n----Start Header Section of request ----");
        log.debug("Method Type : {}"+ requestContext.getMethod());
        iterator = requestContext.getHeaders().keySet().iterator();
        while (iterator.hasNext()) {
            String headerName = iterator.next();
            String headerValue = requestContext.getHeaderString(headerName);
            log.debug("Header Name: "+headerName+" , Header Value : "+ headerValue);
        }
        
        log.debug("----End Header Section of request ----");
    }

    private String readEntityStream(ContainerRequestContext requestContext)
    {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        final InputStream inputStream = requestContext.getEntityStream();
        final StringBuilder builder = new StringBuilder();
        try
        {
            ReaderWriter.writeTo(inputStream, outStream);
            byte[] requestEntity = outStream.toByteArray();
            if (requestEntity.length == 0) {
                builder.append("").append("\n");;
            } else {
                builder.append(new String(requestEntity)).append("\n");;
            }
            requestContext.setEntityStream(new ByteArrayInputStream(requestEntity) );
        } catch (IOException ex) {
            log.error("----Exception occurred while reading entity stream :{}", ex);
        }
        return builder.toString();
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
    	StringBuilder sb = new StringBuilder();
        sb.append("\n\nHeader: ").append(responseContext.getHeaders());
        sb.append("\n\n - Entity: ").append(responseContext.getEntity());
        log.debug("\n\n\n\n\nHTTP RESPONSE : " + sb.toString());
    	
    	String stTime = (String)MDC.get("start-time");
        if(null == stTime || stTime.length() == 0) {
        	return;
        }
    	long startTime = Long.parseLong(stTime);
        long executionTime = System.currentTimeMillis() - startTime;
        log.debug("Total request execution time : {} milliseconds" + executionTime);
        
        //clear the context on exit
        MDC.clear();
    }
}
