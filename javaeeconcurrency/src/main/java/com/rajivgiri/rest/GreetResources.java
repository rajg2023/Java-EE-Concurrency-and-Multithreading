package com.rajivgiri.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("greetUser")
public class GreetResources {

	@GET
	public String greetUser() {
		return "Java EE concurrency starts!";
	}
}
