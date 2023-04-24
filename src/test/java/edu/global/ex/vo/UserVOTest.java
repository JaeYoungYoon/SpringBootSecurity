package edu.global.ex.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class UserVOTest {

	@Test
	void userVOtest() {
		UserVO vo = new UserVO();
		vo.setPassword("1234");
		vo.setUsername("홍길동");
		System.out.println(vo);
		assertNotNull(vo);
		assertEquals(vo.getUsername(), "홍길동1");
	}

}
