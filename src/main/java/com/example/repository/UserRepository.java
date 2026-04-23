package com.example.repository;

import java.util.List;

import com.example.domain.User;

public interface UserRepository {
	
	int countAll();

	List<User> getAllUsers(int startNum, int limit);

	List<User> getUsersByCountry(int startNum, int limit, String userCountry);
	
	User getUserByNumber(int userNumber);

	List<User> getUsersByRange(int minNum, int maxNum);

	void setAddUser(User addUser);

	void setEditUser(User editUser);

	void setDeleteUserByNumber(int userNumber);
}
