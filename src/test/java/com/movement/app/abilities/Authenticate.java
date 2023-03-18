package com.movement.app.abilities;

import java.util.Map;

import com.movement.app.exceptions.CannotAuthenticateException;
import com.movement.app.utils.ConvertCucumberDataTable;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

public class Authenticate implements Ability{
	
	private final String username;
	private final String password;
	
	public Authenticate(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public static Authenticate with(String username, String password) {
		return new Authenticate(username, password);
	}
	
	public String username() {
		return username;
	}
	
	public String password() {
		return password;
	}
	
	public static Authenticate as(Actor actor) {
		if (actor.abilityTo(Authenticate.class) == null) {
			throw new CannotAuthenticateException(actor.getName());
		}
		return actor.abilityTo(Authenticate.class);
	}
	
	public static Authenticate with(DataTable credentialdata) {
		Map<String, String> credentials = ConvertCucumberDataTable.toMap(credentialdata);
		return new Authenticate(credentials.get("username"), credentials.get("password"));
	}
	

}
