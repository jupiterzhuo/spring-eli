package id.equity.jdbc.services;

import java.util.List;

import id.equity.jdbc.exceptions.TransferFundException;
import id.equity.jdbc.models.BankAccount;

public interface BankAccountService {
	public void addBankAccount(BankAccount bankAccount);
	public void editBankAccount(BankAccount bankAccount,Long id);
	public void deleteBankAccount(Long id);
	public List<BankAccount> findAll();
	public BankAccount findById(Long id);
	
	//
    public void addAmount(Long id, Double amount) 
    		throws TransferFundException;
    public void transferFund(Long fromAccount, Long toAccount,Double amount) 
    		throws TransferFundException;
}
