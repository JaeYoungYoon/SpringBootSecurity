package edu.global.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

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

	/*
	 * @Test void testInsertUser() {
	 * 
	 * UserVO user = new UserVO(); user.setUsername("kim4"); user.setPassword(new
	 * BCryptPasswordEncoder().encode("1234")); user.setEnabled(1);
	 * 
	 * userMapper.insertUser(user); userMapper.insertAuthorities(user); }
	 * 
	 * @Test void testInsertAdminUser() { UserVO user = new UserVO();
	 * user.setUsername("admin2"); user.setPassword(new
	 * BCryptPasswordEncoder().encode("admin2")); user.setEnabled(1);
	 * 
	 * userMapper.insertUser(user); userMapper.insertAdminAuthorities(user); }
	 */

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Test
	void testPasswordEncoder() {
		String plainPW = "12345";
		String encodedPW = passwordEncoder.encode(plainPW);

		System.out.println("plain : " + plainPW + " / encoded : " + encodedPW);
		System.out.println(passwordEncoder.matches(plainPW, encodedPW));
		
		
		System.out.println(userVO);

		/* ============================================================== */

		// assertNotEquals(plainPW, encodedPW);
		// assertEquals(plainPW, encodedPW);
		// assertTrue(new BCryptPasswordEncoder().matches(plainPW, encodedPW));
	}

}
