package id.equity.RestExample.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_employee")
@IdClass(Employee.IdClassEmployee.class)
public class Employee {
	@Id
	private String employeeId;
	@Id
	private String companyId;
	@Column(length = 100,nullable = false)
	private String firstName;
	@Column(length = 100)
	private String lastName;
	
	@Data
	static class IdClassEmployee implements Serializable {
		private String employeeId;
		private String companyId;
	}
}
