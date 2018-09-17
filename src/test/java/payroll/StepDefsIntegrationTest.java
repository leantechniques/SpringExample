package payroll;

import static org.hamcrest.MatcherAssert.assertThat;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.StringWriter;


public class StepDefsIntegrationTest extends SpringIntegrationTests {

    @When("^User gets all employees$")
    public void userGetsAllEmployees() throws Throwable {
        executeGet("http://localhost:8080/employees");
    }

    @When("^User gets one employee with id (\\d+)$")
    public void userGetsOneEmployeeWithId(int arg0) throws Throwable {
        String url = "http://localhost:8080/employees/" + arg0;
        executeGet(url);
    }


    @Then("^Returned JSON object contains (\\d+) entry/entries$")
    public void returnedJSONObjectContainsEntryEntries(int numEntries) throws Throwable {
        final JSONObject responseJSON = latestResponse.getJson();

        System.out.println(responseJSON);

        JSONArray data = responseJSON.getJSONArray("employeeList");

        System.out.println(data);

        //JSONObject json = new JSONObject(latestResponse.getResponse())
        assertThat("Failed", false);
    }
}
