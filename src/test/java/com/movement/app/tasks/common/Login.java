package com.movement.app.tasks.common;

import com.movement.app.page_objects.LoginPage;
import com.movement.app.questions.Landing;
import com.movement.app.utils.CommonUtil;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public class Login implements Task {

	private EnvironmentVariables environmentVariables;
	private String username;
	private String password;

	public Login(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public static Login withTerritoryOwnerCedentials() {
		EnvironmentVariables environmentVariables = Injectors.getInjector().getInstance(EnvironmentVariables.class);
		String username = EnvironmentSpecificConfiguration.from(environmentVariables)
				.getProperty("default.admin.username");
		String pwd = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("default.admin.password");

		return new Login(username, pwd);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		actor.wasAbleTo(NavigateTo.theLoginPage());
		
		actor.attemptsTo(
				WaitUntil.the(LoginPage.USERNAME, isVisible()).forNoMoreThan(5).seconds(),
				Enter.theValue(username).into(LoginPage.USERNAME),
				Enter.theValue(password).into(LoginPage.PASSWORD),
				WaitUntil.the(LoginPage.SIGNIN_BTN, isClickable()),
				Click.on(LoginPage.SIGNIN_BTN)
				);
		
		CommonUtil.staticWaitFor((long) 999);
		
		actor.should("Verify Dashboard after login", seeThat(Landing.isComplete()));
		
		CommonUtil.staticWaitFor((long) 999);
	}

}
