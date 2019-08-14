package id.equity.RestExample.Repository;

import org.springframework.data.repository.CrudRepository;

import id.equity.RestExample.models.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

}
