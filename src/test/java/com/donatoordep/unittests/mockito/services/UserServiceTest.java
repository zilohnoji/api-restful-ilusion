package com.donatoordep.unittests.mockito.services;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.donatoordep.dto.UserDTO;
import com.donatoordep.entities.User;
import com.donatoordep.mapper.UserMapper;
import com.donatoordep.repositories.UserRepository;
import com.donatoordep.services.UserService;

@TestInstance(Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@Mock
	private UserMapper userMapper;

	@InjectMocks
	private UserService service;

	@BeforeEach
	void setUpMocks() throws Exception {
	}

	@Test
	void testInsertToSuccess() {
		UserDTO dto = new UserDTO("PedroJunit5", "Junit5AndMockito@gmail.com", "21967005260");
		User user = userMapper.toEntity(dto);

		Mockito.when(userRepository.insert(user)).thenReturn(user);

		UserDTO result = service.insert(dto);
		User result2 = userRepository.insert(user);

		Assertions.assertEquals(result, result2);

	}

	@Test
	void testFindById() {
		User user = new User("Pedro", "ed@gmail.com", "4234235");
		user.setId("123");

		Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
		UserDTO dto = service.findById(user.getId());

		Assertions.assertEquals(user.getId(), dto.getId());
	}

	@Test
	void testFindAll() {
		List<User> list = new ArrayList<>();

		Mockito.when(userRepository.findAll()).thenReturn(list);

		List<UserDTO> users = service.findAll();
		Assertions.assertNotNull(users);
		Assertions.assertEquals(users, list);

	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteAllByIdList() {
		fail("Not yet implemented");
	}

}
