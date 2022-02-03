package com.rajivgiri.rest;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ContextService;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.rajivgiri.runnables.ContextServiceRunnable;

@Path("contextservice")
public class ContextServiceAPIResources {

	
	@Resource(lookup = "java:jboss/ee/concurrency/context/default")

	private ContextService service;
	
	@GET
	@Path("/")
	public String accessSecurityInfo() {
		ContextServiceRunnable runnable = new ContextServiceRunnable();
		/*
		 * Thread thread = new Thread(runnable); thread.start();
		 */
		Runnable proxy = service.createContextualProxy(runnable, Runnable.class);
		Thread thread = new Thread(proxy);
		thread.start();
		
		return "Context capturing information";
	}
	
}


