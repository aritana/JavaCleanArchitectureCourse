package br.com.aritana.school.infra.student;

import br.com.aritana.school.domain.student.CPF;
import br.com.aritana.school.domain.student.Email;
import br.com.aritana.school.domain.student.PhoneNumber;
import br.com.aritana.school.domain.student.Student;
import br.com.aritana.school.domain.student.StudentRepository;
import br.com.aritana.school.domain.student.exceptions.StudentNotFound;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryJDBC implements StudentRepository {

  private final Connection connection;

  public StudentRepositoryJDBC(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void enroll(Student student) {
    try {
      String sql = "INSERT INTO STUDENT VALUES(?,?,?)";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setString(1, student.getCpf());
      ps.setString(2, student.getName());
      ps.setString(3, student.getEmail());
      ps.execute();

      sql = "INSERT INTO PHONE_NUMBER VALUES(?,?,?)";
      ps = connection.prepareStatement(sql);
      for (PhoneNumber phoneNumber : student.getPhoneNumbers()
      ) {
        ps.setString(1, phoneNumber.getCountryCode());
        ps.setString(2, phoneNumber.getddd());
        ps.setString(3, phoneNumber.getNumber());
        ps.execute();
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Student searchByCPF(CPF cpf) {
    try {
      String sql = "SELECT id, name, email FROM STUDENT WHERE cpf  = ?";
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setString(1, cpf.getNumber());

      ResultSet rs = ps.executeQuery();
      boolean found = rs.next();
      if (!found) {
        throw new StudentNotFound(cpf);
      }

      String name = rs.getString("name");
      Email email = new Email(rs.getString("email"));
      Student studentFound = new Student(cpf, name, email);

      Long id = rs.getLong("id");
      sql = "SELECT ddd, phoneNumber FROM PHONE_NUMBER WHERE student_id =?";
      ps = connection.prepareStatement(sql);
      ps.setLong(1, id);
      rs = ps.executeQuery();
      while (rs.next()) {
        String countryCode = rs.getString("countryCode");
        String ddd = rs.getString("ddd");
        String number = rs.getString("number");
        studentFound.setPhoneNumber(countryCode, ddd, number);
      }
      return studentFound;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public List<Student> listAllEnrolledStudents() {
    try {
      String sql = "SELECT id, cpf, name, email FROM STUDENT";
      PreparedStatement ps = connection.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      List<Student> students = new ArrayList<>();

      while (rs.next()) {
        CPF cpf = new CPF(rs.getString("cpf"));
        String name = rs.getString("name");
        Email email = new Email(rs.getString("email"));
        Student student = new Student(cpf,name,email);

        Long id = rs.getLong("id");
        sql = "SELECT ddd, phoneNumber FROM PHONE_NUMBER WHERE student_id =?";
        ps = connection.prepareStatement(sql);
        ps.setLong(1, id);
        rs = ps.executeQuery();
        while (rs.next()) {
          String countryCode = rs.getString("countryCode");
          String ddd = rs.getString("ddd");
          String number = rs.getString("number");
          student.setPhoneNumber(countryCode, ddd, number);
        }
        students.add(student);
      }
      return  students;
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
