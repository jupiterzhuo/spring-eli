package id.equity.RestExample.controllers;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.equity.RestExample.Repository.UserRepository;
import id.equity.RestExample.dto.user.CreateUserDTO;
import id.equity.RestExample.exceptions.EntityNotFoundException;
import id.equity.RestExample.models.Role;
import id.equity.RestExample.services.UserService;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private UserService userService;
	
	
	//Save 
	@PostMapping("users")
	public ResponseEntity<CreateUserDTO> addNewUser (
			@Valid@RequestBody CreateUserDTO newUser) throws EntityNotFoundException{
		userService.saveAll(newUser, 1, null);
		return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
	}
}
