package com.rajivgiri.runnables;

import org.jboss.logging.Logger;

public class LoginProcessor implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// final Logger.Level level = null;
		String message = "Logging the DATA for logging resources";
		new RuntimeException("Error");

		System.out.println("Thread: " + Thread.currentThread().getName());
		// Logger.getLogger(LoginProcessor.class.getName()).log(org.jboss.logging.Logger.Level.INFO,
		// message, log,t );

		final Logger log = Logger.getLogger(LoginProcessor.class.getPackage().getName());
		log.info(message);

	}

}
