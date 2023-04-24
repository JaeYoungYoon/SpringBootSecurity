package edu.global.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.global.ex.vo.UserVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserVO userVO;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Disabled
	@Test
	void insertUserTest() {
		UserVO user = new UserVO();
		user.setUsername("kim5");
		user.setPassword(new BCryptPasswordEncoder().encode("1234"));
		user.setEnabled(1);
		userMapper.insertUser(user);
		userMapper.insertAuthorities(user);
	}
	
	@Test
	void insertAdminTest() {
		UserVO user = new UserVO();
		user.setUsername("admin5");
		user.setPassword(new BCryptPasswordEncoder().encode("admin5"));
		user.setEnabled(1);
		userMapper.insertUser(user);
		userMapper.insertAdminAuthorities(user);
	}
	
}
