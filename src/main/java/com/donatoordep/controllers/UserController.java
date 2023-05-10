package com.donatoordep.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.donatoordep.dto.UserDTO;
import com.donatoordep.services.UserService;

@RestController
@RequestMapping("/api/user/v1")
public class UserController {

	@Autowired
	UserService service;

	@GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserDTO> findById(@PathVariable(value = "id") String id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@PostMapping(path = "/insert", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO user) {
		return ResponseEntity.ok().body(service.insert(user));
	}

	@GetMapping(path = "/all", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<List<UserDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@PutMapping(path = "/update", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserDTO> update(@RequestBody UserDTO dto) {
		return ResponseEntity.ok().body(service.update(dto));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteById(@RequestParam(name = "id") String id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/delete/all")
	public ResponseEntity<?> deleteAllByIdList(@RequestBody List<String> ids) {
		service.deleteAllByIdList(ids);
		return ResponseEntity.noContent().build();
	}

}
