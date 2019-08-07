package id.equity.SpringMVC.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import id.equity.SpringMVC.Model.Student;

@Controller
public class HomeController {

	static List<Student> students =new ArrayList<Student>();
	// initial data
	static {
		students.add(new Student("Jupiter", "Zhuo", 36));
		students.add(new Student("Davin", "Zhuo", 1));
		students.add(new Student("Hosea", "Zhuo", 7));
	}
	
	@RequestMapping(value= {"/","/index"},method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("greeting", 
				"hello Ini adalah pesan dari controller");
		model.addAttribute("students", students);
		return "Home";
	}
	@RequestMapping(value= "/add-student",method = RequestMethod.GET)
	public String addStudent(Model model) {
		Student studentForm = new Student();
		model.addAttribute("student", studentForm);
		return "AddStudent";
	}
	@RequestMapping(value= "/add-student",method = RequestMethod.POST)
	public String saveStudent(Student student,Model model) {
		String firstName = student.getFirstName();
		String lastName = student.getLastName();
		Integer age = student.getAge();
		//Validation
		if(firstName !=null && firstName.length() >0 &&
				lastName !=null && lastName.length() >0 &&
				age !=null) {
			// save or add item students list
			students.add(new Student(firstName, lastName, age));
			return "redirect:/";
		}
		model.addAttribute("errorMessage", "Field is mandatory");
		return "AddStudent";
		
	}
	
	public String about() {
		return "About";
	}
}
