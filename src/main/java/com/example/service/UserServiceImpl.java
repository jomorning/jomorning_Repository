package com.example.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.domain.User;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public int countAll() {
		int countAll = userRepository.countAll();
		return countAll;
	}

	@Override
	public List<User> getAllUsers(int startNum, int limit) {
		List<User> allUsers = userRepository.getAllUsers(startNum, limit);
		return allUsers;
	}
	
	@Override
	public List<User> getUsersByCountry(int startNum, int limit, String userCountry) {
		List<User> usersByCountry = userRepository.getUsersByCountry(startNum, limit, userCountry);
		return usersByCountry;
	}

	@Override
	public User getUserByNumber(int userNumber) {
		User userByNumber = userRepository.getUserByNumber(userNumber);
		return userByNumber;
	}

	@Override
	public List<User> getUsersByRange(int minNum, int maxNum) {
		List<User> usersByRange = userRepository.getUsersByRange(minNum, maxNum);
		return usersByRange;
	}

	@Override
	public void setAddUser(User addUser) {
		uploadFile(addUser, addUser.getMultipartFile());
		userRepository.setAddUser(addUser);
	}

	@Override
	public void setEditUser(User editUser) {
		User userById = userRepository.getUserByNumber(editUser.getUserNumber());
		userById.setUserId(editUser.getUserId());
		userById.setUserName(editUser.getUserName());
		userById.setUserAge(editUser.getUserAge());
		userById.setUserEmail(editUser.getUserEmail());
		userById.setUserCountry(editUser.getUserCountry());
		
		if (editUser.getUserPw() != null && !editUser.getUserPw().trim().isEmpty()) {
			userById.setUserPw(editUser.getUserPw());
		}
		
		uploadFile(userById, editUser.getMultipartFile());
		userRepository.setEditUser(userById);
	}

	@Override
	public void setDeleteUserByNumber(int userNumber) {
		userRepository.setDeleteUserByNumber(userNumber);
	}
	
	private void uploadFile(User user, MultipartFile file) {
		MultipartFile multipartFile = file;
		
		if (multipartFile != null && !multipartFile.isEmpty()) {
			String originalFileName = multipartFile.getOriginalFilename();
			String savedFileName = UUID.randomUUID().toString() + "_" + originalFileName;
			File savedFile = new File("C:\\jomorning_upload", savedFileName);
			
			try {
				multipartFile.transferTo(savedFile);
				user.setFileName(savedFileName);
			} catch (Exception e) {
				throw new RuntimeException("경로: [" + savedFile + "] 업로드 실패", e);
			}
		}
	}

}
