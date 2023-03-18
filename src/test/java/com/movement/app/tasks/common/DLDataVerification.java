package com.movement.app.tasks.common;

import com.movement.app.page_objects.DLPage;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;

public class DLDataVerification extends UIInteractions implements Task {
	
	public DLDataVerification() {
		
	}
	
	public static DLDataVerification UnderlineData() {
		
		return new DLDataVerification();
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		
		actor.attemptsTo(Scroll.to(DLPage.ADDED_TIME).andAlignToTop());
		waitABit(1000);
		
		String addedtime = DLPage.ADDED_TIME.resolveFor(actor).getText();
		
		Ensure.that(addedtime).contains("seconds");
		waitABit(999);
	}

}
