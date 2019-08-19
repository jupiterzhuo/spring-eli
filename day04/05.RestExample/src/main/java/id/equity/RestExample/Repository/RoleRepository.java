package id.equity.RestExample.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import id.equity.RestExample.models.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {

}
