package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.RegisterPojo;
import pojo.RegisterResponsePojo;

import static utilities.Authentication.tokenGenerate;

public class API_US001 {

    RegisterPojo registerExpected = new RegisterPojo();
    Faker faker = new Faker();
    Response response;

    @Given("Kullanici kayit icin data olusturur")
    public void kullaniciKayitIcinDataOlusturur() {

        String email = faker.internet().emailAddress();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        String login = (firstname + "_" + lastname).toLowerCase();
        String password = faker.internet().password(8,13,true,true, true);
        String ssn = faker.idNumber().ssnValid();

        registerExpected.setEmail(email);
        registerExpected.setFirstName(firstname);
        registerExpected.setLastName(lastname);
        registerExpected.setLogin(login);
        registerExpected.setPassword(password);
        registerExpected.setSsn(ssn);

        System.out.println(registerExpected);

    }

    @And("Kullanici kayit icin post request gonderir")
    public void kullaniciKayitIcinPostRequestGonderir() {

        // kısayol oluşturmak için Menü->Code->Save as Live Template->Abbrevation xxxxx
        response = RestAssured.given()
                                        .contentType(ContentType.JSON)
                                        .header("Authorization", "Bearer " + tokenGenerate())
                                        .body(registerExpected)
                                        .when()
                                        .post("https://medunna.com/api/register");

        response.prettyPrint();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        String date = response.header("date");
        System.out.println("date = " + date);

    }

    @Then("Kullanici API kayitlirini dogrular")
    public void kullaniciAPIKayitliriniDogrular() {

        RegisterResponsePojo actualData = response.as(RegisterResponsePojo.class); // responsedan gelen json datayi ResponseActual dat type ına aktardık.
        Assert.assertEquals(registerExpected.getFirstName(), actualData.getFirstName());
        Assert.assertEquals(registerExpected.getLastName(), actualData.getLastName());
        Assert.assertEquals(registerExpected.getEmail(), actualData.getEmail());
        Assert.assertEquals(registerExpected.getLogin(), actualData.getLogin());
        Assert.assertEquals(registerExpected.getSsn(), actualData.getSsn());
        System.out.println(actualData);
    }
}
