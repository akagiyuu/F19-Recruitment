
package tech.fcode.recruitment.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tech.fcode.recruitment.entities.Student;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public interface StudentRepository extends CrudRepository<Student, Integer> {

    Student getByStudentId(String studentId);
    
    Student getByPersonalEmail(String personalEmail);

    Student getByPhone(String phone);

    @Query("SELECT s FROM Student s")
    ArrayList<Student> getAllStudent();
}
