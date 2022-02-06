package com.rajivgiri.rest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedThreadFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.rajivgiri.runnables.LoginProcessor;

@Path("logging")
public class LoginResources {

	@Resource(lookup = "java:jboss/ee/concurrency/factory/default")
	private ManagedThreadFactory threadFactory;

	@GET
	@Path("/")
	public String logData() {

		Thread thread = threadFactory.newThread(new LoginProcessor());
		thread.setName("Logging-Thread");
		thread.start();

		ExecutorService service = getApplicationPool();
		for (int i = 0; i < 7; i++) {
			service.submit(new LoginProcessor());
		}
		return "logging thread doing its job,check console";

	}

	public ExecutorService getApplicationPool() {

		ExecutorService service = new ThreadPoolExecutor(3, 10, 5, TimeUnit.SECONDS, new ArrayBlockingQueue(2),
				threadFactory);
		return service;

	}

}
