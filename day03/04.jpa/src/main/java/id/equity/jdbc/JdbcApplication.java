package id.equity.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import id.equity.jdbc.models.BankAccount;
//import id.equity.jdbc.services.BankAccountService;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {
//	@Autowired
//	private BankAccountService bankAccountService;
	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//Insert Data
//		BankAccount bankAccount = new BankAccount();
//		bankAccount.setFirstName("Jupiter");
//		bankAccount.setLastName("Zhuo");
//		bankAccount.setBalance((double) 100000000);
//		bankAccountService.addBankAccount(bankAccount);
	}

}
