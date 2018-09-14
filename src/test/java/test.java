import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(format = "pretty", features = "src/test/resources")
public class test {

}
