package br.com.increaseit.common.util;

import java.util.Locale;
import java.util.ResourceBundle;

public class Messages {

	private ResourceBundle resourdeBundle;
	
	private static Messages instance;
	
	private Messages() {
		resourdeBundle = ResourceBundle.getBundle("messages", Locale.getDefault());
	}
	
	public static Messages getInstance() {
		if (instance == null) {
			instance = new Messages();
		}
		return instance;
	}
	public String getMessage(String key) {
		return resourdeBundle.getString(key);
	}
	
}
