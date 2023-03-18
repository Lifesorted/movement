package com.movement.app.page_objects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("page:home.page")
public class Dashboard extends PageObject{

	public static Target TASKS = Target.the("task list").locatedBy("//label[contains(text(),'The Movement')]");
	
	public boolean islandingComplete(Actor actor) {
		double startTime = System.currentTimeMillis();
		while(System.currentTimeMillis() < startTime + getWaitForTimeout().getSeconds() * 1000) {
			String previousState = BrowseTheWeb.as(actor).getDriver().getPageSource();
			waitABit(1500);
			if (previousState.equals(BrowseTheWeb.as(actor).getDriver().getPageSource())) {
				break;
			}
		}
		
		BrowseTheWeb.as(actor).waitFor(TASKS.getCssOrXPathSelector());
		return TASKS.isVisibleFor(actor);
	}
}
