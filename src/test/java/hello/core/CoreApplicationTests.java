package hello.core;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoreApplicationTests {

	@Test
	void contextLoads() {
	}

}

// MemberRepository - 싱글 빈을 예상했지만 2개를 찾음
// MemberServiceImpl - 생성자 매개변수 0개?