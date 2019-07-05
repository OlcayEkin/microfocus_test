package com.ebay.hook;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Setting up cucumber options
 */
@CucumberOptions(plugin = { "pretty",

        "html:target/site/cucumber-html-report",

        "json:target/site/cucumber-json-report.json"

}, monochrome = true,
        features = "src/test/java/resources ", glue = { "" })
@RunWith(Cucumber.class)
public class CucumberRunner {
}
