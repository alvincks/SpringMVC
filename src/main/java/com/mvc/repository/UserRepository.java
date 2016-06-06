package com.mvc.repository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository<T, P> implements UserRepositoryInterface<T,P>{
	
	public boolean isValidUser(T compareFrom, P compareTo){
		
		return findUserByObject(compareFrom,compareTo);
	}

	private boolean findUserByObject(T compareFrom, P compareTo){
		System.out.println("compareFrom :"+ compareFrom.getClass().getName());
		System.out.println("compareTo :"+ compareTo.getClass().getName());
		return StringUtils.containsIgnoreCase(compareFrom.getClass().getName(),compareTo.getClass().getName());
	}
}
