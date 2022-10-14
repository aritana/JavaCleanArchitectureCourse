import java.time.LocalDateTime;

public class Recommendations {

  private Student referred;
  private Student referee;
  private LocalDateTime referDate;


  public Recommendations(Student referred, Student referee) {
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
