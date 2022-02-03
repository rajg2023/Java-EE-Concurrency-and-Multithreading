package com.rajivgiri.runnables;

import java.security.AccessControlContext;
import java.security.AccessController;

import javax.security.auth.Subject;

public class ContextServiceRunnable implements Runnable {
	
	@Override
	public void run() {
		System.out.println("Thread "+ Thread.currentThread().getName());
		
		
		Subject subject = Subject.getSubject(AccessController.getContext());
		  if (subject == null) {
		        subject = new Subject();
		    } else {
		        subject = new Subject(false, subject.getPrincipals(), subject.getPublicCredentials(), subject.getPrivateCredentials());
		    }		
		
		System.out.println("Security information from a normal Thread: " + subject);
		
		
		

		
	}

}
