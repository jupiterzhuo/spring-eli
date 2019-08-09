package id.equity.jdbc.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import id.equity.jdbc.models.BankAccount;

@Repository
public class BankAccountRepositoryImpl implements BankAccountRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public void addBankAccount(BankAccount bankAccount) {
		// TODO Auto-generated method stub
		String sql ="INSERT "
				+ "INTO bank_account (first_name, last_name,balance) "
				+ "VALUES (?,?,?)";
		jdbcTemplate.update(sql, 
				bankAccount.getFirstName(),
				bankAccount.getLastName(),
				bankAccount.getBalance());
	}

	@Override
	public void editBankAccount(BankAccount bankAccount, Long id) {
		// TODO Auto-generated method stub
		String sql ="UPDATE bank_account \"\n" + 
				"+ \"SET first_name = ?,last_name =?,balance =? \"\n" + 
				"+ \"WHERE id=?";
		jdbcTemplate.update(sql, 
				bankAccount.getFirstName(),
				bankAccount.getLastName(),
				bankAccount.getBalance(),
				id);
		
	}

	@Override
	public void deleteBankAccount(Long id) {
		// TODO Auto-generated method stub
		String sql ="DELETE FROM bank_account WHERE id=?";
		jdbcTemplate.update(sql, id);
		
	}

	@Override
	public List<BankAccount> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM bank_account";
		List<BankAccount>  lstBankAccount =  
				jdbcTemplate.query(sql, 
						new BeanPropertyRowMapper<BankAccount>(BankAccount.class));
		return lstBankAccount;
	}

	@Override
	public BankAccount findById(Long id) {
		// TODO Auto-generated method stub
		String sql ="SELECT * FROM bank_account WHERE id=?";
		BankAccount bankAccount = jdbcTemplate.queryForObject(sql, 
					new Object[] {id},
					new BeanPropertyRowMapper<BankAccount>(BankAccount.class));
		return bankAccount;
	}

	@Override
	public void updateBalance(Double balance, Long id) {
		// TODO Auto-generated method stub
		 String sql = "UPDATE bank_account "
	        		+ "SET balance =? "
	        		+ "WHERE id=?";
		 jdbcTemplate.update(sql,balance,id);
		
	}

}
