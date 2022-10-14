import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PhoneNumberTest {

  @Test
  void shouldNotCreatePhoneNumbersWithWrongCountryCode() {
    assertThrows(IllegalArgumentException.class, () -> new PhoneNumber(null,"31","123456489"));
    assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("","31","123456489"));
    assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("111","31","123456489"));
  }
  @Test
  void shouldNotCreatePhoneNumbersWithWrongDDD() {
    assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("55",null,"123456489"));
    assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("55","","123456489"));
    assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("55","123","123456489"));
  }
  @Test
  void shouldNotCreatePhoneNumbersWithWrongPhoneNumber() {
    assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("55","31",null));
    assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("55","31",""));
    assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("55","31","1234567"));
    assertThrows(IllegalArgumentException.class, () -> new PhoneNumber("55","31","0123456789"));
  }

  @Test
  void shouldCreatePhoneNumbersWithCorrectPhoneNumber() {
    String countryCode="55";
    String ddd="31";
    String number="12345678";
    PhoneNumber phoneNumber = new PhoneNumber(countryCode,ddd,number);
    assertEquals(countryCode,phoneNumber.getCountryCode());
  }

  @Test
  void shouldCreatePhoneNumbersWith9digitsOnPhoneNumber() {
    String countryCode="55";
    String ddd="31";
    String number="012345678";
    PhoneNumber phoneNumber = new PhoneNumber(countryCode,ddd,number);
    assertEquals(countryCode,phoneNumber.getCountryCode());
  }

}