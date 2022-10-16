package br.com.aritana.school.application.recommendation.student.enroll;

import br.com.aritana.school.domain.student.CPF;
import br.com.aritana.school.domain.student.Email;
import br.com.aritana.school.domain.student.Student;

public class EnrollStudentDto {

  private String studentName;
  private String studentCPF;
  private String studentEmail;

  public EnrollStudentDto(String studentName, String studentCPF, String studentEmail) {
    this.studentName = studentName;
    this.studentCPF = studentCPF;
    this.studentEmail = studentEmail;
  }

  public Student createStudent() {
    return new Student(new CPF(studentCPF), studentName, new Email(studentEmail));
  }
}
