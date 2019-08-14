package id.equity.RestExample.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import id.equity.RestExample.Repository.StudentRepository;
import id.equity.RestExample.exceptions.GenericErrorException;
import id.equity.RestExample.models.Student;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	//Get All
	//@RequestMapping(value= {"students"}, method = RequestMethod.GET)
	@GetMapping("students")
	public List<Student> getAllStudent() {
		return (List<Student>) studentRepository.findAll();
		//return "Get All Student";
	}
	//Get By Id
	@GetMapping("students/{id}")
	public Student getStudentById(@PathVariable Long id) {
		Optional<Student> student=studentRepository.findById(id);
		
		if(student.isPresent()) {
			return student.get();
		}
		else {
			throw new GenericErrorException("Student With id :" + id + " Not Found");
		}

	}
	//Save
	@PostMapping("students")
	public Student addNewStudent(@Valid@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	//edit
	@PutMapping("students/{id}")
	public Student updateStudent(@Valid@RequestBody Student updatedStudent,
			@PathVariable Long id) {
		//Find id 
		return studentRepository.findById(id)
		.map(student -> {
			student.setName(updatedStudent.getName());
			student.setAge(updatedStudent.getAge());
			return studentRepository.save(student);
		})
		.orElseThrow(
				()-> new GenericErrorException("Student With id :" + id + " Not Found"));

	}
	
	//Delete
	@DeleteMapping("students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		return studentRepository.findById(id)
		.map(student -> {
			studentRepository.delete(student);
			return "Record Success To delete";
				})
		.orElseThrow(
				()-> new GenericErrorException("Student With id :" + id + " Not Found"));

	}
}
