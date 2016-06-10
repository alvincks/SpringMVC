package com.mvc.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class UserObjectApproachRepository<T, P> implements UserRepositoryInterface<T, P> {

	public boolean isValidUser(T compareFrom, P compareTo) {

		return findUserByObject(compareFrom, compareTo);
	}

	private boolean findUserByObject(T compareFrom, P compareTo) {
		System.out.println("compareFrom :" + compareFrom.getClass().getName());
		System.out.println("compareTo :" + compareTo.getClass().getName());
		getJSONProperties();
		return StringUtils.containsIgnoreCase(compareFrom.getClass().getName(), compareTo.getClass().getName());
	}

	// may use Jackson or Gson if need to convert json to object or otherwise.
	private boolean getJSONProperties() {
		JSONParser parser = new JSONParser();
		try {
			
			Resource resource = new ClassPathResource("username.json");
			System.out.println("file existing?" + resource.exists());
			FileReader fr = new FileReader(resource.getFile());
			
			//
			JSONObject jsonObj = (JSONObject) parser.parse(fr); 
			String username = (String) jsonObj.get("username");
			String password = (String) jsonObj.get("password");
			System.out.println("username:" + username + ", password:" + password);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
