package com.movement.app.questions;

import com.movement.app.page_objects.Dashboard;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Landing extends UIInteractionSteps implements Question<Boolean> {

	private Dashboard dashboard;
	
	public static Landing isComplete() {
		return new Landing();
	}
	
	@Override
	public Boolean answeredBy(Actor actor) {
		
		return dashboard.islandingComplete(actor);
	}

	
}
