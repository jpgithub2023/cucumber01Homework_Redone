package runners;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="classpath:features",
		glue="steps",
		tags= "@BankCashFeature", 
		monochrome= true,
		dryRun= false,
		plugin= {
				"pretty",
				"html: target/reports/cucumber.html",
				"json: target/reports/cucumber.json",
					}
			)

public class BankAndCashRunner {

}
