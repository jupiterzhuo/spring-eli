package id.equity.jdbc.models;

import lombok.Data;

@Data
public class BankAccount {
	private Long id; 
	private String firstName;
	private String lastName;
	private Double balance;
	
}
