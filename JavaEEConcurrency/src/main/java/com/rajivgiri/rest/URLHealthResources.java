package com.rajivgiri.rest;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.rajivgiri.runnables.URLHealthProcessor;

@Path("urlCheck")
public class URLHealthResources {

	@Resource(lookup = "java:jboss/ee/concurrency/scheduler/default")
	private ManagedScheduledExecutorService scheduledExecutorService;

	@GET
	@Path("/")
	public String checkHealthOfApp() {

		String message = "";
		scheduledExecutorService.schedule(new URLHealthProcessor(), 3, TimeUnit.SECONDS);

		message = "Health Check Initiated";
		return message;

	}

}
