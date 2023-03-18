package com.movement.app.steps;

import java.util.logging.Logger;

import com.movement.app.tasks.common.DLDataVerification;
import com.movement.app.tasks.common.DailyLeadership;
import com.movement.app.tasks.common.Login;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.ensure.Ensure;
import static com.movement.app.questions.ApplicationEnquiryResult.*;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;

public class DailyLeadershipSteps extends UIInteractionSteps {
	
	private static Logger logger = Logger.getLogger(DailyLeadershipSteps.class.getName());
	
	private Actor TerritoryOwner;
	
	@Before(order = 2)
	public void setup() {
		TerritoryOwner = OnStage.theActor("TO");
	}

	@Given("{word} is on HomePage of the application")
	public void user_is_on_HomePage_of_the_application(String role) {
		TerritoryOwner.assignName(role);
		givenThat(TerritoryOwner).attemptsTo(Login.withTerritoryOwnerCedentials());
	}
	
	@Given("attempts to create new DL to publish")
	public void attempts_to_create_new_dl_to_publish(DataTable dataTable) {
		givenThat(TerritoryOwner).attemptsTo(DailyLeadership.UnderlineData(dataTable));
	}

	@When("DL data verified successfully on dashboard")
	public void dl_data_verified_successfully_on_dashboard() {
	    givenThat(TerritoryOwner).attemptsTo(DLDataVerification.UnderlineData());
	}

	@Then("New DL added under timeline should {string}")
	public void New_DL_added_under_timeline_should(String status) {
	    givenThat(TerritoryOwner).attemptsTo(Ensure.that("DL appearance", hasAppearanceStatus()).isEqualTo(status));
	}
}
