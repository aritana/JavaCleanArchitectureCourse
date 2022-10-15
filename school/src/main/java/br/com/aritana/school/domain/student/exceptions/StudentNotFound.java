package br.com.aritana.school.domain.student.exceptions;

import br.com.aritana.school.domain.student.CPF;

public class StudentNotFound extends RuntimeException {

  public StudentNotFound(CPF cpf) {
    super("CPF not found:"+cpf.getNumber());
  }
}
