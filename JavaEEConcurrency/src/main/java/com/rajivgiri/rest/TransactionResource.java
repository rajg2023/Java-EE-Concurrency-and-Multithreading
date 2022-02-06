package com.rajivgiri.rest;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.rajivgiri.runnables.TransactionProcessor;

@Path("transactions")
public class TransactionResource {

	@Resource(lookup = "java:jboss/ee/concurrency/executor/default")
	private ManagedExecutorService service;

	@POST
	public String executeTransactions() {
		service.submit(new TransactionProcessor());

		return "Transaction submitted, please check console";

	}

}
