package edu.global.ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.global.ex.mapper.UserMapper;
import edu.global.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	public void addUser(UserVO user) {
		log.info("addUser()..");

		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);

	}

	public void addUser2(UserVO user) {
		log.info("addUser()..");

		userMapper.insertUser(user);
		user = null; // 에러 유도
		userMapper.insertAuthorities(user);

	}

	@Transactional
	public void addUser3(UserVO user) {
		log.info("addUser()..");

		userMapper.insertUser(user);
		user = null; // 에러 유도
		userMapper.insertAuthorities(user);

	}

	@Transactional
	public void addUser4(UserVO user) throws Exception {
		log.info("addUser()..");

		userMapper.insertUser(user); 
		userMapper.insertAuthorities(user);

		throw new Exception("Exception (Checked Exception)");
	}
	
	@Transactional
	public void addUser5(UserVO user) throws Exception {
		log.info("addUser()..");

		userMapper.insertUser(user); 
		userMapper.insertAuthorities(user);

		throw new RuntimeException("Exception (Unchecked Exception)");
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void addUser6(UserVO user) throws Exception {
		log.info("addUser()..");

		userMapper.insertUser(user); 
		userMapper.insertAuthorities(user);

		throw new Exception("Exception (Checked Exception)");
	}

}