package id.equity.jdbc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="bank_account")
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id; 
	
	@Column(name = "first_name",nullable = false,length = 100)
	private String firstName;
	
	@Column(name = "last_name",length = 100)
	private String lastName;
	
	@Column(name = "balance",nullable = false)
	private Double balance;
	@Column(name="age",nullable = false)
	private int age;
	
	public BankAccount(String firstName, String lastName, Double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}
	
	
	
}
