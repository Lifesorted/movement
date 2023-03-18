package com.movement.app.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = {"src/test/resources/features/Daily_Leadership/create_new_daily_leadership.feature"},
		plugin = { "pretty" },
		glue = {"com.movement.app"},
		tags = "@SmokeTest",
		dryRun = false)
public class MVRunner {
}