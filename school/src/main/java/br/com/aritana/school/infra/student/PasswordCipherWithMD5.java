package br.com.aritana.school.infra.student;

import br.com.aritana.school.domain.student.PasswordEncrypt;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordCipherWithMD5 implements PasswordEncrypt {

  @Override
  public String encryptPassword(String password) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(password.getBytes());
      byte[] bytes = md.digest();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < bytes.length; i++) {
        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
      }
      return sb.toString();
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Error generating password");
    }
  }

  @Override
  public boolean validatePassword(String encryptedPassword, String password) {
    return encryptedPassword.equals(encryptPassword(password));
  }
}
