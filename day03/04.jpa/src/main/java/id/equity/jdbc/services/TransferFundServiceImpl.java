package id.equity.jdbc.services;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import id.equity.jdbc.exceptions.TransferFundException;
import id.equity.jdbc.models.BankAccount;

@Service
@Transactional
public class TransferFundServiceImpl implements TransferFundService {
	
	@Autowired
	private EntityManager entityManager;
	
	public BankAccount findById(Long id) {
		return this.entityManager.find(BankAccount.class, id);
	}
	public int updateBalance(long id, Double balance) {
		String sql = "UPDATE bank_account a "
				+ "SET a.balance= " + balance + " WHERE a.id = " + id;
		Query query = this.entityManager.createNativeQuery(sql);
		int result = query.executeUpdate();
		return result;
	}
	@Transactional(propagation = Propagation.MANDATORY)
	@Override
	public void addAmount(Long id, Double amount) throws TransferFundException {
		// TODO Auto-generated method stub
		BankAccount bankAccount = this.findById(id);
		if(bankAccount == null) {
			throw new TransferFundException("Account ID :" + id + " Not found!");
		}
		double newAmount = bankAccount.getBalance() + amount;
		if (bankAccount.getBalance() + amount < 0) {
			throw new TransferFundException("The Money in account :" + id + " is Not enough!");
		}
				
		bankAccount.setBalance(newAmount);
		int result = this.updateBalance(bankAccount.getId(), bankAccount.getBalance());
		
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW,rollbackFor = TransferFundException.class)
	@Override
	public void transferFund(Long fromAccount, Long toAccount, Double amount) throws TransferFundException {
		// TODO Auto-generated method stub
		addAmount(toAccount, amount);
		addAmount(fromAccount, -amount);
	}

}
