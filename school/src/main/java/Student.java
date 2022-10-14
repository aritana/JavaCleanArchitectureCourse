import java.util.ArrayList;
import java.util.List;

public class Student {

  private String name;
  private CPF cpf;
  private Email email;

  private List<PhoneNumber>phones = new ArrayList();

  public void setPhoneNumber(String countryCode, String ddd, String number  ){
    this.phones.add(new PhoneNumber(countryCode,ddd,number));
  }

  public Student(CPF cpf,String name,  Email email) {
    this.name = name;
    this.cpf = cpf;
    this.email = email;
  }
}
