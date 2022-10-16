package br.com.aritana.school.application.recommendation;

import br.com.aritana.school.domain.student.Student;

public interface SendEmailApplication {

  void sendTo(Student referred);
}
