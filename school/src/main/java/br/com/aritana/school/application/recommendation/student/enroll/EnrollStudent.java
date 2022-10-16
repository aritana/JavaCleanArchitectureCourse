package br.com.aritana.school.application.recommendation.student.enroll;

import br.com.aritana.school.domain.student.Student;
import br.com.aritana.school.domain.student.StudentRepository;

public class EnrollStudent {
  private final StudentRepository repository;

  public EnrollStudent(StudentRepository repository) {
    this.repository = repository;
  }

  public void enroll(EnrollStudentDto studentData){

  }

}
