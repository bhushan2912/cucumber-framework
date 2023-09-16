package org.testRunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/org/features/SearchFuncPage.feature",
		glue = {"stepDefinitions","org/applicationHooks"},
		monochrome=true,
		dryRun=false,
//		tags="Smoke",
		plugin = {"pretty",
				"html:target/html_report/cucumber_reports.html",
				"junit:target/junit_report/junit_reports.xml",
				"json:target/json_report/json_reports.json",
			"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
			}
//		format = {"pretty","html:report"} //for older versions
		)
public class MyTestRunner {
	
}