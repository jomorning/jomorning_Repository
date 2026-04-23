package com.example.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.domain.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserNumber(rs.getInt("u_number"));
		user.setUserId(rs.getString("u_id"));
		user.setUserPw(rs.getString("u_pw"));
		user.setUserRole(rs.getString("u_role"));
		user.setUserName(rs.getString("u_name"));
		user.setUserAge(rs.getInt("u_age"));
		user.setUserEmail(rs.getString("u_email"));
		user.setUserCountry(rs.getString("u_country"));
		user.setFileName(rs.getString("u_fileName"));
		return user;
	}
}
