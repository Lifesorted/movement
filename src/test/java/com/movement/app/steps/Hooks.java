package com.movement.app.steps;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.util.EnvironmentVariables;

public class Hooks {
	
	private static Logger logger = Logger.getLogger(Hooks.class.getName());
	
	@Managed
	private WebDriver userBrowser;
	
	@Managed
	private EnvironmentVariables environmentVariables;
	
	private Actor territoryOwner;
	
	@Before(order = 1)
	public void setup() {
		OnStage.setTheStage(new OnlineCast());
		territoryOwner = OnStage.theActorCalled("TO");
		territoryOwner.whoCan(BrowseTheWeb.with(userBrowser));
	}
	
	@After(order = 1)
	public void tearDown() {
		userBrowser.close();
		userBrowser.quit();
	}
		
}
