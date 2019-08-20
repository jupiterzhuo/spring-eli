package id.equity.RestExample.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_contact")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 100)
	private String city;
	@Column(length = 20)
	private String phone;
	//Relasi one to one
	@OneToOne(fetch = FetchType.LAZY,optional = false)
	@JoinColumn(name = "student_id",
	nullable = false,unique = true)
	private Student student;
}
