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
        System.out.println(responseJSON);
        final HttpStatus statusCode = latestResponse.getResponse().getStatusCode();
        assertThat("Status code is incorrect: " + responseJSON, statusCode.value(), is(200));

        if (numEntries>1) {
            JSONObject embedded = responseJSON.getJSONObject("_embedded");
            JSONArray employeeList = embedded.getJSONArray("employeeList");

            assertThat("Count is wrong: " + employeeList.length(), employeeList.length(), is(numEntries));
        }
        else{
            String s = responseJSON.getString("firstName");
            assertThat("No employee", s.length()>0);
        }
    }

    @Then("^(\\d+) is returned$")
    public void isReturned(int expectedHttpCode) throws Throwable {
        // Write code here that turns the phrase above into concrete actions;
        final JSONObject responseJSON = latestResponse.getJson();
        System.out.println(responseJSON);
        final HttpStatus statusCode = latestResponse.getResponse().getStatusCode();

        assertThat("Status code is incorrect: " + responseJSON, statusCode.value(), is(expectedHttpCode));
    }
}
