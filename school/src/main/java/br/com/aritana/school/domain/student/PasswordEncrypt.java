package br.com.aritana.school.domain.student;

public interface PasswordEncrypt {

  String encryptPassword(String password);

  boolean validatePassword(String encryptedPassword, String password);



}
