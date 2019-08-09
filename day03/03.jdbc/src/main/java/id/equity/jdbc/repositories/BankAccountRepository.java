package id.equity.jdbc.repositories;

import java.util.List;

import id.equity.jdbc.models.BankAccount;

public interface BankAccountRepository {

	//CRUD CREATE READ UPDATE DELETE
	
	public void addBankAccount(BankAccount bankAccount);
	public void editBankAccount(BankAccount bankAccount,Long id);
	public void deleteBankAccount(Long id);
	public List<BankAccount> findAll();
	public BankAccount findById(Long id);
	
	public void updateBalance(Double balance,Long id);
	
	
}
