package br.com.aritana.domain.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import br.com.aritana.school.domain.student.Email;

class EmailTest {

  @Test
  void shouldNotCreateEmailsWithWrongAddress(){
    assertThrows(IllegalArgumentException.class,()-> new Email(null));
    assertThrows(IllegalArgumentException.class,()-> new Email(""));
    assertThrows(IllegalArgumentException.class,()-> new Email("invalide-mail"));
  }

  @Test
  void shouldCreateEmailsWithCorrectAddress(){
    String address = "fulano@gmail.com";
    Email email =  new Email(address);
    assertEquals(address,email.getAddress());
  }

}