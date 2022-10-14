package br.com.aritana.school.domain.recommendation;

import br.com.aritana.school.domain.student.Student;
import java.time.LocalDateTime;

public class Recommendation {

  private Student referred;
  private Student referee;
  private LocalDateTime referDate;


  public Recommendation(Student referred, Student referee) {
    this.referred = referred;
    this.referee = referee;
    this.referDate = LocalDateTime.now();
  }

  public Student getReferred() {
    return referred;
  }

  public Student getReferee() {
    return referee;
  }

  public LocalDateTime getReferDate() {
    return referDate;
  }
}
