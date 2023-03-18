package com.movement.app.page_objects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("page:login.page")
public class LoginPage extends PageObject {

	public static Target USERNAME = Target.the("username").locatedBy("//input[@name='txtEmail']");
	public static Target PASSWORD = Target.the("username").locatedBy("//input[@name='txtPass']");
	public static Target SIGNIN_BTN = Target.the("username").locatedBy("//button[@id='btnSubmit']");
	
}
