package br.com.aritana.school.application.recommendation.student.enroll;

import static org.junit.jupiter.api.Assertions.*;

import br.com.aritana.school.domain.student.CPF;
import br.com.aritana.school.domain.student.Email;
import br.com.aritana.school.domain.student.Student;
import br.com.aritana.school.infra.student.StudentRepositoryJDBC;
import br.com.aritana.school.infra.student.StudentRepositoryMemory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class EnrollStudentTest {

  @Mock
  private StudentRepositoryJDBC studentRepositoryJDBC;

  private EnrollStudent enrollStudent;
  private String name = "Fulano da Silva";
  private String cpf = "123.456.789-00";
  private String email = "silvaFulano@email.com";
  private Student studentJDBC = new Student(new CPF(cpf), name, new Email(email));

  @BeforeEach
  public void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void studentShouldBePersistedInMemory() {
    StudentRepositoryMemory repository = new StudentRepositoryMemory();
    enrollStudent = new EnrollStudent(repository);

    EnrollStudentDto newStudentData = new EnrollStudentDto(name, cpf, email);
    enrollStudent.execute(newStudentData);

    Student student = repository.searchByCPF(new CPF(cpf));

    assertEquals(name, student.getName());
    assertEquals(cpf, student.getCpf());
    assertEquals(email, student.getEmail());
  }

  @Test
  void studentShouldBePersistedInJDBC() {
    enrollStudent = new EnrollStudent(studentRepositoryJDBC);
    EnrollStudentDto newStudentData = new EnrollStudentDto(name, cpf, email);
    enrollStudent.execute(newStudentData);

    Mockito.when(studentRepositoryJDBC.searchByCPF(Mockito.any()))
        .thenReturn(studentJDBC);

    Student student = studentRepositoryJDBC.searchByCPF(new CPF(cpf));
    assertEquals(name, student.getName());
    assertEquals(cpf, student.getCpf());
    assertEquals(email, student.getEmail());
  }
}