package br.com.aritana.school.domain.student;

import java.util.List;

public interface StudentRepository {

  void enroll(Student student);//public and abstract
  Student searchByCPF(CPF cpf);
  List<Student> listAllEnrolledStudents();

}
