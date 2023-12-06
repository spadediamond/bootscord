package com.kosmos.bootscord;

import com.kosmos.bootscord.entities.BootscordUser;
import com.kosmos.bootscord.repos.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BootscordApplicationTests {

	@Autowired
	private UserRepository repository;

	@Test
	void createUser() {
		BootscordUser user = new BootscordUser();
		user.setUserName("bestElfMage123");
		user.setPassword("magic123");
		user.setDisplayName("Frieren");

		repository.save(user);
	}

	@Test
	void getUserById() {
		BootscordUser user = repository.findById(1).get();
		assertEquals("Frieren", user.getDisplayName());
		System.out.println(user);
	}

	@Test
	void contextLoads() {
	}

}
