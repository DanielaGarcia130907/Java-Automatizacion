package cucumberTesting;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		plugin = { "pretty" }, 
		glue = { "cucumberTesting" }, 
		features = "src/test/resources/features/paginaWeb.feature"

)
public class RunCucumberTest {
}
