/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hdang09.repositories;

import hdang09.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Admin
 */
public interface StudentRepository extends CrudRepository<Student, Integer> {

    @Query("SELECT s FROM Student s where s.studentId = :studentId")
    Student getByStudentId(@Param("studentId") String studentId);
    
    @Query("SELECT s FROM Student s where s.personalEmail = :personalEmail")
    Student getByPersonalEmail(@Param("personalEmail") String personalEmail);
    
}
