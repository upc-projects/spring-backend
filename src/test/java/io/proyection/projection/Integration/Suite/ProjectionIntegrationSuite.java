package io.proyection.projection.Integration.Suite;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources",
		glue = {"io.proyection.projection.Integration.Test"},
		plugin = {
				"pretty",
				"html:target/cucumber",
				"json:target/cucumber.json",
				"junit:target/cucumber_junit_report.xml"
			}
		)
public class ProjectionIntegrationSuite {

}
