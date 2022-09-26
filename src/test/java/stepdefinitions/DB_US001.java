package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.ConfigReader;

import java.sql.*;

public class DB_US001 {

    String url = "jdbc:postgresql://localhost:5432/school"; // Connection Url = jdbc:postgresql://+HOST+":"+PORT+"/DATABASENAME";
    String username = ConfigReader.getProperty("db_username");
    String password = ConfigReader.getProperty("db_password");

    Connection connection;
    Statement statement;
    ResultSet resultSet;


    @Given("user connects to the database")
    public void userConnectsToTheDatabase() throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement  = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 	ResultSet.CONCUR_READ_ONLY);
    }

    @Given("user connects to the student table")
    public void userConnectsToTheStudentTable() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM public.students");
    }

    @And("print the total row count and verify")
    public void printTheTotalRowCountAndVerify() throws SQLException {

        int count = 0;
        while (resultSet.next()){
            count++;
        }
        System.out.println("Tablodaki satır sayısı => " + count);
        Assert.assertEquals(count, 3);
    }

    @And("print first student name and verify")
    public void printFirstStudentNameAndVerify() throws SQLException {

        resultSet.first();
        String val = resultSet.getString("student_name");
        Assert.assertEquals(val, "ahmet");

        System.out.println("ilk ögrenci ismi = " + val);
    }

    @And("print last student name and verify")
    public void printLastStudentNameAndVerify() throws SQLException {

        resultSet.last();
        String val = resultSet.getString("student_name");
        Assert.assertEquals(val, "sultan");

        System.out.println("son ögrenci ismi = " + val);
    }

    @And("print spesific student name and verify")
    public void printSpesificStudentNameAndVerify() throws SQLException {

        resultSet.absolute(2);
        String val = resultSet.getString("student_name");
        Assert.assertEquals(val, "sedat");

        System.out.println(2 + ". ögrenci ismi = " + val);
    }
}
