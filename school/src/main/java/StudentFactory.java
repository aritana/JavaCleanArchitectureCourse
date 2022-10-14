public class StudentFactory {

  private Student student;

  public StudentFactory withNameCPFandEmail(String name, String cpf, String email) {
    this.student = new Student(new CPF(cpf), name, new Email(email));
    return this;
  }

  public StudentFactory withPhoneNumber(String countryCode, String ddd, String number) {
    this.student.setPhoneNumber(countryCode, ddd, number);
    return this;
  }

  public Student getStudent() {
    return student;
  }
}


