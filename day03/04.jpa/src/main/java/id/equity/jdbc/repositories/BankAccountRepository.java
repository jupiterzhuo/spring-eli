package id.equity.jdbc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import id.equity.jdbc.models.BankAccount;

public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
	//derived method
	List<BankAccount> findByFirstNameLike(String firstName);
}
