package br.com.sicredi.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		strict = true,
		features = "src/test/resources/features",
		glue = {"br.com.sicredi.steps"},
		plugin = {"pretty", "json:target/cucumber.json"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE
		)
public class RunnerTest {
	
}