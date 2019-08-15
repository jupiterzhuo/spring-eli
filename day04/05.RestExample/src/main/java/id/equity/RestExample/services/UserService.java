package id.equity.RestExample.services;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import id.equity.RestExample.Repository.RoleRepository;
import id.equity.RestExample.Repository.UserRepository;
import id.equity.RestExample.dto.user.CreateUserDTO;
import id.equity.RestExample.dto.user.RoleUserDTO;
import id.equity.RestExample.exceptions.EntityNotFoundException;
import id.equity.RestExample.models.Role;
import id.equity.RestExample.models.User;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	//Web Security config
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//Save User
	@Transactional(propagation = Propagation.MANDATORY)
	public User saveUser(CreateUserDTO createUserDTO,
			@Nullable Long userId) {
		User user  = new User();
		//Jika user tersebut di edit maka userId di set
		if (userId!=null) {
			user.setId(userId);
		}
		
		user.setUserName(createUserDTO.getUserName());
		user.setFirstName(createUserDTO.getFirstName());
		user.setLastName(createUserDTO.getLastName());
		user.setPassword(passwordEncoder.encode(createUserDTO.getPasssword()));
		return userRepository.save(user);
		
	}
	//Save User Role
	@Transactional(propagation = Propagation.MANDATORY)
	public void  saveUserRole(Long userId,Long roleId) 
			throws EntityNotFoundException {
		
		Role role =roleRepository.findById(roleId)
			.orElseThrow(
					()-> new EntityNotFoundException(Role.class, "id :" ,roleId.toString()));
		
		userRepository.findById(userId)
			.map(user->{
				if(user.getRoles()==null) {
					List<Role> roles = new ArrayList<>();
					roles.add(role);
					user.setRoles(roles);
				}
				else {
					user.getRoles().add(role);
				}
				return userRepository.save(user).getRoles();
			}).orElseThrow(
					()-> new EntityNotFoundException(User.class, "id :" ,userId.toString()));
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = EntityNotFoundException.class)
	//Method for call saveuser anda saveUserRole
	public void saveAll(CreateUserDTO createUserDTO,
			int action, @Nullable Long userId) throws EntityNotFoundException {
		User user;
		Long newUserId = null;
		//add
		if (action ==1) {
			user = this.saveUser(createUserDTO, null);
			newUserId=user.getId();
		}
		//edit
		else {
			user = this.saveUser(createUserDTO, userId);
			newUserId = userId;
		}
		for(RoleUserDTO roleId : createUserDTO.getRoleId()) {
			this.saveUserRole(newUserId, roleId.getId());
			
		}
	}
}
