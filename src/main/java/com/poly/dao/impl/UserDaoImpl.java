package com.poly.dao.impl;

import java.util.List;
import java.util.Map;

import com.poly.constant.NameStored;
import com.poly.dao.AbstractDao;
import com.poly.dao.UserDao;
import com.poly.entity.User;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return super.findById(User.class, id);
	}

	@Override
	public User finByEmail(String email) {
		// TODO Auto-generated method stub
		String sql="SELECT o FROM User o WHERE o.email = ?0";
		return super.findOne(User.class, sql, email);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		String sql="SELECT o FROM User o WHERE o.username = ?0";
		return super.findOne(User.class, sql, username);
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		String sql="SELECT o FROM User o WHERE o.username = ?0 AND o.password= ?1";
		return super.findOne(User.class, sql, username,password);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(User.class, true);
	}
	@Override
	public List<User> findAll(int pageNUmber, int pageSize) {
		// TODO Auto-generated method stub
		return super.findAll(User.class, true, pageNUmber, pageSize);
	}

	@Override
	public List<User> findUsersLikedVideoByVideoHref(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return super.callStored(NameStored.FIND_USER_LIKED_VIDEO_BY_VIDEO_HREF, params);
	}

	
}
