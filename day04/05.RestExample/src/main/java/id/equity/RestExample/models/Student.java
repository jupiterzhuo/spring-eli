package id.equity.RestExample.models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import id.equity.RestExample.configs.Auditable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_student")
public class Student extends Auditable<String>  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, length = 100)
	@NotEmpty(message = "Name not Empty")
	private String name;
	private int age;
	
	//Relasi One To One
	@OneToOne(cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "student" )
	private Contact contact;
	
	//Relasi One to Many
	@OneToMany(cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY,
			mappedBy = "student")
	private List<Assignment> Assigments;
	
	//Relasi many to many
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "tbl_student_subject", 
			joinColumns = @JoinColumn(name="student_id",referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name="subject_id",referencedColumnName = "id")
			)
	private List<Subject> subjects;

}
