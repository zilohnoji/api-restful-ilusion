package com.donatoordep.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.donatoordep.controllers.UserController;
import com.donatoordep.dto.UserDTO;
import com.donatoordep.entities.User;
import com.donatoordep.exceptions.ResourceNotFoundException;
import com.donatoordep.mapper.UserMapper;
import com.donatoordep.repositories.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repo;

	@Autowired
	private UserMapper mapper;

	public UserDTO insert(UserDTO userDto) {
		UserDTO dto = mapper.toDto(repo.insert(mapper.toEntity(userDto)));
		return dto;
	}

	public UserDTO findById(String id) {
		UserDTO dto = mapper
				.toDto(repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Error: Resource not found")))
				.add(linkTo(methodOn(UserController.class).findById(id)).withSelfRel());
		return dto;
	}

	public List<UserDTO> findAll() {
		List<UserDTO> list = repo.findAll().stream().map(x -> mapper.toDto(x)).collect(Collectors.toList());
		list.forEach(x -> x.add(linkTo(methodOn(UserController.class).findAll()).withSelfRel()));
		return list;
	}

	public UserDTO update(UserDTO userDto) {
		User user = mapper.toEntity(findById(userDto.getId()));
		user.setCellphone(userDto.getCellphone());
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		UserDTO dto = mapper.toDto(repo.save(user));
		return dto;

	}

	public void deleteById(String id) {
		repo.deleteById(id);
	}

	public void deleteAllByIdList(List<String> ids) {
		ids.forEach(this::deleteById);
	}
}
