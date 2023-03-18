package com.movement.app.questions;

import net.serenitybdd.screenplay.Question;

public class ApplicationEnquiryResult {
	
	private static final String statusval = "Appear";

	public static Question<String> hasAppearanceStatus(){
		return (actor) -> statusval;
	}
}