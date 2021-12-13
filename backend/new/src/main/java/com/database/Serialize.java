package com.database;

import com.google.gson.Gson;

public class Serialize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user01 = new User("Ali");
		
		Gson gson = new Gson();
		
		String json = gson.toJson(user01);
		
		System.out.println(json);

	}

}
