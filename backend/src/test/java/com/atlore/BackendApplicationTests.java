package com.atlore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
	"spring.autoconfigure.exclude="
		+ "org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration,"
		+ "org.springframework.boot.data.redis.autoconfigure.RedisAutoConfiguration,"
		+ "org.springframework.boot.orm.jpa.autoconfigure.HibernateJpaAutoConfiguration,"
		+ "org.springframework.boot.flyway.autoconfigure.FlywayAutoConfiguration"
})
class BackendApplicationTests {

	@Test
	void contextLoads() {
	}

}

