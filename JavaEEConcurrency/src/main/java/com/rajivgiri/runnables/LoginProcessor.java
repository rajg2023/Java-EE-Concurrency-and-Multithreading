package com.rajivgiri.runnables;

import java.util.logging.Level;

import org.jboss.logging.Logger;
import org.jboss.logging.Message;

public class LoginProcessor implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//final Logger.Level level = null;
		String message ="Logging the DATA for logging resources";
		//Object log = null;
	    Throwable t = new RuntimeException("Error");
		
		System.out.println("Thread: "+ Thread.currentThread().getName());
		//Logger.getLogger(LoginProcessor.class.getName()).log(org.jboss.logging.Logger.Level.INFO, message, log,t );
		
		final Logger log = Logger.getLogger(LoginProcessor.class.getPackage().getName());
		log.info(message);
		
		
		
	}

}
