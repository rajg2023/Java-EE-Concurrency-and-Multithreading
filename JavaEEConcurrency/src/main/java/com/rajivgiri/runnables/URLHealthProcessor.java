package com.rajivgiri.runnables;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLHealthProcessor implements Runnable {

	private static final String urlName = "https://www.google.com";

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String statusOfApp = "";
		URL url;
		try {
			url = new URL(urlName);

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			int responseCode = connection.getResponseCode();

			if (responseCode == 200) {

				statusOfApp = "Yes, it is working!";

			} else {
				statusOfApp = "Sorry, 404 Error";

			}
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Status of the App :" + statusOfApp);

	}

}
