package br.com.aritana.school.infra.student;

import br.com.aritana.school.domain.student.CPF;
import br.com.aritana.school.domain.student.Student;
import br.com.aritana.school.domain.student.StudentRepository;
import br.com.aritana.school.domain.student.exceptions.StudentNotFound;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryMemory implements StudentRepository {

  private List<Student> enrolled = new ArrayList<>();


  @Override
  public void enroll(Student student) {
    this.enrolled.add(student);
  }

  @Override
  public Student searchByCPF(CPF cpf) {
    return this.enrolled.stream()
        .filter(a-> a.getCpf().equals(cpf.getNumber()))
        .findFirst()
        .orElseThrow(()-> new StudentNotFound(cpf));
  }

  @Override
  public List<Student> listAllEnrolledStudents() {
    return this.enrolled;
  }
}
