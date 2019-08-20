package id.equity.RestExample.Repository;

import org.springframework.data.repository.CrudRepository;

import id.equity.RestExample.models.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
