package gr.ote.finalproject;

import org.junit.jupiter.api.Test;

import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class PropertyOwnerControllerTest {

    @Test
    public void findAllPropertyOwners() throws Exception{
        URL url = new URL("http://localhost:8080/api/propertyOwners/all");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        //Getting the response code
        int responsecode = conn.getResponseCode();

        assertEquals(200, responsecode);
    }
}
