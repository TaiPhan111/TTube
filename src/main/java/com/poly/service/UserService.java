package com.poly.service;

import java.util.List;

import com.poly.dto.UserDto;
import com.poly.entity.User;

public interface UserService {
	User findById(Integer id);
	User findByEmail(String email);
	User findByUsername(String username);
	User Login(String username, String password);
	User resetPassword(String email);
	List<User> findAll();
	List<User> findAll(int pageNumber, int pageSize);
	User create (String username, String password, String email);
	User update (User entity);
	User delete (String username);
	List<UserDto> findUserLikedVideoByVideoHref(String href);
}
