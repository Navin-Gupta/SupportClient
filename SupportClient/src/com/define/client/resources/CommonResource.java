package com.define.client.resources;

import java.net.Socket;

public class CommonResource {
	
	public static void handleException(Exception ex, String location) {
		System.out.println("Exception at :" + location + "\nDescription : \n" + ex);
	}
	
	public static Socket client;
	public static String type;
	public static Student student;
}
