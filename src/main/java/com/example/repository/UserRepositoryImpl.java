package com.example.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	JdbcTemplate template;
	
	public void setJdbcTemplate(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int countAll() {
		String SQL = "SELECT COUNT(*) FROM user";
		int countAll = template.queryForObject(SQL, Integer.class);
		return countAll;
	}

	@Override
	public List<User> getAllUsers(int startNum, int limit) {
		String SQL = "SELECT * FROM user ORDER BY u_number LIMIT ?,?";
		List<User> allUsers = template.query(SQL, new UserRowMapper(), startNum, limit);
		return allUsers;
	}
	
	@Override
	public List<User> getUsersByCountry(int startNum, int limit, String userCountry) {
		String SQL = "SELECT * FROM user WHERE u_country = ? LIMIT ?,?";
		List<User> usersByCountry = template.query(SQL, new UserRowMapper(), userCountry, startNum, limit);
		return usersByCountry;
	}
	
	@Override
	public User getUserByNumber(int userNumber) {
		String SQL = "SELECT * FROM user WHERE u_number = ?";
		List<User> userByNumberTemp = template.query(SQL, new UserRowMapper(), userNumber);
		if (userByNumberTemp.isEmpty()) {
			return null;
		}
		User userByNumber = userByNumberTemp.get(0);
		return userByNumber;
	}

	@Override
	public List<User> getUsersByRange(int minNum, int maxNum) {
		String SQL = "SELECT * FROM user WHERE u_number BETWEEN ? AND ?";
		List<User> usersByRange = template.query(SQL, new UserRowMapper(), minNum, maxNum);
		return usersByRange;
	}

	@Override
	public void setAddUser(User addUser) {
		String SQL = "INSERT INTO user (u_id, u_pw, u_name, u_age, u_email, u_country, u_fileName) VALUES (?,?,?,?,?,?,?)";
		template.update(SQL, addUser.getUserId(), addUser.getUserPw(), addUser.getUserName(), addUser.getUserAge(), addUser.getUserEmail(), addUser.getUserCountry(), addUser.getFileName());
	}

	@Override
	public void setEditUser(User editUser) {
		String SQL = "UPDATE user SET u_id = ?, u_pw = ?, u_name = ?, u_age = ?, u_email = ?, u_country = ?, u_fileName = ? WHERE u_number = ?";
		template.update(SQL, editUser.getUserId(), editUser.getUserPw(), editUser.getUserName(), editUser.getUserAge(), editUser.getUserEmail(), editUser.getUserCountry(), editUser.getFileName(), editUser.getUserNumber());
	}

	@Override
	public void setDeleteUserByNumber(int userNumber) {
		String SQL = "DELETE FROM user WHERE u_number = ?";
		template.update(SQL, userNumber);
	}

}
