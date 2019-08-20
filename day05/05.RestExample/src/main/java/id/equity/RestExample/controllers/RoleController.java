package id.equity.RestExample.controllers;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.equity.RestExample.Repository.RoleRepository;
import id.equity.RestExample.dto.role.CreateRoleDTO;
import id.equity.RestExample.dto.role.ListRoleDTO;
import id.equity.RestExample.exceptions.EntityNotFoundException;
import id.equity.RestExample.exceptions.GenericErrorException;
import id.equity.RestExample.models.Role;

@RestController
@RequestMapping("/api/v1/")
public class RoleController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//Get All 
	@GetMapping("roles")
	public ResponseEntity<Page<ListRoleDTO>> getAllRole(
			@RequestParam(name = "page") int page,
			@RequestParam(name="size") int size){
		
		Pageable pageable = PageRequest.of(page,size);
		Page<Role> lstRole =  roleRepository.findAll(pageable);
		Type targetType = new TypeToken<Page<ListRoleDTO>>() {}.getType();
		return ResponseEntity.ok(modelMapper.map(lstRole, targetType));
		
	}
	
	//Get by Id
	@GetMapping("roles/{id}")
	public ResponseEntity<ListRoleDTO> getRoleById(@PathVariable Long id) 
			throws EntityNotFoundException{
		Role role = roleRepository.findById(id)
				.orElseThrow(()-> new EntityNotFoundException(Role.class,"id",id.toString()));
		return ResponseEntity.ok(modelMapper.map(role, ListRoleDTO.class));

	}
	
	//Save 
	@PostMapping("roles")
	public ResponseEntity<CreateRoleDTO> addNewRole (
			@Valid@RequestBody CreateRoleDTO newRole){
		roleRepository.save(modelMapper.map(newRole, Role.class));
		return ResponseEntity.status(HttpStatus.CREATED).body(newRole);
	}
	
	//Edit
	@PutMapping("/roles/{id}")
	public ResponseEntity<CreateRoleDTO> updateRole(@PathVariable Long id,
			@Valid @RequestBody CreateRoleDTO updatedRoles) throws EntityNotFoundException {
		roleRepository.findById(id)
			.orElseThrow(()->new EntityNotFoundException(Role.class, "id",id.toString()));
		Role role = modelMapper.map(updatedRoles,Role.class);
		role.setId(id);
		roleRepository.save(role);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedRoles);
	}
		
}
	
	
