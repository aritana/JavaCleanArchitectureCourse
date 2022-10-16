package br.com.aritana.school;

import br.com.aritana.school.application.recommendation.student.enroll.EnrollStudent;
import br.com.aritana.school.application.recommendation.student.enroll.EnrollStudentDto;
import br.com.aritana.school.infra.student.StudentRepositoryMemory;

public class EnrollStudentByCommandLine {

  public static void main(String[] args) {
    String name = "Fulano da Silva";
    String cpf = "123.456.789-00";
    String email = "silvaFulano@email.com";

    EnrollStudent enrollStudent = new EnrollStudent(new StudentRepositoryMemory());
    enrollStudent.execute(new EnrollStudentDto(name,cpf,email));
  }
}
