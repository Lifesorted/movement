package com.movement.app.tasks.common;

import com.movement.app.page_objects.LoginPage;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
	
	public static Performable theLoginPage() {
		return Task.where("{0} opens the login page",
				Open.browserOn().the(LoginPage.class));
	}

}
