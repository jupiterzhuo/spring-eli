package id.equity.jdbc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import id.equity.jdbc.exceptions.TransferFundException;
import id.equity.jdbc.models.BankAccount;
import id.equity.jdbc.repositories.BankAccountRepository;
@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService{
	
	@Autowired
	private BankAccountRepository bankRepository;
	
	@Override
	public void addBankAccount(BankAccount bankAccount) {
		// TODO Auto-generated method stub
		bankRepository.addBankAccount(bankAccount);
		System.out.println("Success!!");
	}

	@Override
	public void editBankAccount(BankAccount bankAccount, Long id) {
		// TODO Auto-generated method stub
		bankRepository.editBankAccount(bankAccount, id);
	}

	@Override
	public void deleteBankAccount(Long id) {
		// TODO Auto-generated method stub
		bankRepository.deleteBankAccount(id);
	}

	@Override
	public List<BankAccount> findAll() {
		// TODO Auto-generated method stub
		return bankRepository.findAll();
	}

	@Override
	public BankAccount findById(Long id) {
		// TODO Auto-generated method stub
		return bankRepository.findById(id);
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void addAmount(Long id, Double amount) throws TransferFundException {
		// TODO Auto-generated method stub
		 BankAccount bankAccount = bankRepository.findById(id);
	     if (bankAccount == null){
	    	 throw new TransferFundException("Account ID :" +id + " Not Found!");
	     }
	     double newAmount =  bankAccount.getBalance() + amount;
	     if(bankAccount.getBalance() + amount < 0){
	    	 throw new TransferFundException("The money in the account '" + id + "' is not enough (" + bankAccount.getBalance() + ")");
	     }
	     bankAccount.setBalance(newAmount);
	     bankRepository.updateBalance(bankAccount.getBalance(),bankAccount.getId());
		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW,
	rollbackFor = TransferFundException.class)
	
	public void transferFund(Long fromAccount, Long toAccount, Double amount) throws TransferFundException {
		// TODO Auto-generated method stub
		addAmount(toAccount, amount);
		addAmount(fromAccount, -amount);
	}

}
