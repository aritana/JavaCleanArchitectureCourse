public class PhoneNumber {

  private String countryCode;
  private String ddd;
  private String number;

  public PhoneNumber(String countryCode, String ddd, String number) {

    if(countryCode == null || !countryCode.matches("\\d{2}") ){
      throw new IllegalArgumentException("Invalid Country Code");
    }
    if(ddd == null || !ddd.matches("\\d{2}") ){
      throw new IllegalArgumentException("Invalid ddd");
    }
    if(number == null || !number.matches("\\d{8,9}") ){
      throw new IllegalArgumentException("Invalid number");
    }

    this.countryCode = countryCode;
    this.ddd = ddd;
    this.number = number;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public String getDdd() {
    return ddd;
  }

  public String getNumber() {
    return number;
  }
}
