package id.equity.RestExample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.equity.RestExample.Repository.RoleRepository;
import id.equity.RestExample.models.Role;

@RestController
@RequestMapping("/api/v1/")
public class RoleController {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping("roles")
	public List<Role> getAllRole(){
		return (List<Role>) roleRepository.findAll();
	}
}
