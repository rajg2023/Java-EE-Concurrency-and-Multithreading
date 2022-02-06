package com.rajivgiri.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("greetUser")

public class GreetResource {

	@GET
	@Path("/")
	public String greetUser() {

		return "Java EE Starts";
	}

}
