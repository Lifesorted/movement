package com.movement.app.utils;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class CommonUIInteractions extends PageObject {

	public void isLandingComplete(Actor actor) {

        double startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() < startTime + getWaitForTimeout().getSeconds() * 2000) {
            String previousState = BrowseTheWeb.as(actor).getDriver().getPageSource();
            waitABit(1000);
            if (previousState.equals(BrowseTheWeb.as(actor).getDriver().getPageSource())) {
                break;
            }
        }
    }
}
