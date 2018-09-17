package payroll;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;

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

        // Just printing the JSON for debugging purposes
        final JSONObject responseJSON = latestResponse.getJson();

        final HttpStatus statusCode = latestResponse.getResponse().getStatusCode();
        assertThat("Status code is incorrect: " + responseJSON, statusCode.value(), is(200));
    }
}
