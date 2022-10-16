package br.com.aritana.school.domain.student;

import java.util.ArrayList;
import java.util.List;

public class Student {

  private String name;
  private CPF cpf;
  private Email email;

  private String password;

  private List<PhoneNumber> phones = new ArrayList();

  public void setPhoneNumber(String countryCode, String ddd, String number) {
    this.phones.add(new PhoneNumber(countryCode, ddd, number));
  }

  public Student(CPF cpf, String name, Email email) {
    this.name = name;
    this.cpf = cpf;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public String getCpf() {
    return cpf.getNumber();
  }

  public String getEmail() {
    return email.getAddress();
  }

  public List<PhoneNumber> getPhoneNumbers() {
    return phones;
  }
}
