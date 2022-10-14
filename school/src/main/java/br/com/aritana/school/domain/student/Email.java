package br.com.aritana.school.domain.student;

public class Email {

  private String address;

  public Email(String endereco) {
    if (endereco == null || !endereco.matches(
        "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
      throw new IllegalArgumentException("Invalid e-mail!");
    }
    this.address = endereco;
  }

  public String getAddress() {
    return address;
  }

}
