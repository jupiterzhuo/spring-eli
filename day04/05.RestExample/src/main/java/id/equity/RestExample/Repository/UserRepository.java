package id.equity.RestExample.Repository;

import org.springframework.data.repository.CrudRepository;

import id.equity.RestExample.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
	// Derived Method
	User findByUserName(String Username);
}
