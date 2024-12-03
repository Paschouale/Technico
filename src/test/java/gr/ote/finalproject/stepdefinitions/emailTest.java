package gr.ote.finalproject.stepdefinitions;

import gr.ote.finalproject.domain.PropertyOwner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class emailTest {
    @Given("The application is running")
    public void checkAppStatus() throws Exception{
        URL url = new URL("http://localhost:8080/api/propertyOwners/all");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        //Getting the response code
        int responsecode = conn.getResponseCode();

        assertEquals(200, responsecode);
    }
    @When("I make a search with a userEmail: {string}")
    public void searchWithUserEmail(String email) throws Exception{
        URL url = new URL("http://localhost:8080/api/propertyOwners/email/" + email);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        //Getting the response code
        int responsecode = conn.getResponseCode();
        Object propertyOwner = conn.getContent();

        assertEquals(200, responsecode);
    }
    @Then("I get the User Details")
    public void result(){

    }
}