package com.mvc.repository;

public interface UserRepositoryInterface<T,P> {
	
	public boolean isValidUser(T compareFrom,P compareTo);

}
