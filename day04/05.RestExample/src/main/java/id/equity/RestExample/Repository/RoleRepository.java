package id.equity.RestExample.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import id.equity.RestExample.models.Role;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
	Page<Role> findAll(Pageable pageable);
}
