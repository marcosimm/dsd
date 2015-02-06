package com.pe.upc.sisex.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.axis.client.*;

public class RestClient {

	// http://localhost:8080/RESTfulExample/json/product/get
	public static void main(String[] args) {

		try {

			String url = "http://edgardma.koding.io:3000/sunat/ruc/20301821388";
			HttpURLConnection conn = getServiceConnection(url, "GET");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	public static HttpURLConnection getServiceConnection(String serviceUrl,
			String method) {
		HttpURLConnection conn = null;
		try {
			URL url = new URL(serviceUrl);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(method);
			conn.setRequestProperty("Accept", "application/json");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static String getJson(String serviceUrl, String method) {
		String json = "";

		try {
			HttpURLConnection conn = getServiceConnection(serviceUrl, method);
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				json += output;
			}

			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	public static Call getCallService(String ws){
		Service servicio= new Service();
		try {
			Call caller=(Call)servicio.createCall();
			caller.setTargetEndpointAddress(ws);
			return caller;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}