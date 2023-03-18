package com.movement.app.tasks.common;

import java.util.List;
import java.util.Map;

import com.movement.app.page_objects.DLPage;
import com.movement.app.utils.ConvertCucumberDataTable;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class DailyLeadership extends UIInteractions implements Task {

	private String date;
	private String attend;
	private String meetingnotes;

	public DailyLeadership(String date, String attend, String meetingnotes) {
		this.date = date;
		this.attend = attend;
		this.meetingnotes = meetingnotes;
	}

	public static DailyLeadership UnderlineData(DataTable dldetails) {
		Map<String, String> dlinfo = ConvertCucumberDataTable.toMap(dldetails);
		String date = dlinfo.get("Date");
		String attend = dlinfo.get("Attended");
		String meetingnotes = dlinfo.get("MeetingNotes");
		return new DailyLeadership(date, attend, meetingnotes);
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(WaitUntil.the(DLPage.ADD_DL, isClickable()).then(Click.on(DLPage.ADD_DL)));
		waitABit(1500);
		
		actor.attemptsTo(SelectFromOptions.byVisibleText(attend).from(DLPage.SELECT_PRESENCE0));
		actor.attemptsTo(SelectFromOptions.byVisibleText(attend).from(DLPage.SELECT_PRESENCE1));
		actor.attemptsTo(SelectFromOptions.byVisibleText(attend).from(DLPage.SELECT_PRESENCE2));
		actor.attemptsTo(SelectFromOptions.byVisibleText(attend).from(DLPage.SELECT_PRESENCE3));
		actor.attemptsTo(SelectFromOptions.byVisibleText(attend).from(DLPage.SELECT_PRESENCE4));
		actor.attemptsTo(SelectFromOptions.byVisibleText(attend).from(DLPage.SELECT_PRESENCE5));
		waitABit(1500);

		actor.attemptsTo(Enter.keyValues(meetingnotes).into(DLPage.MEETING_NOTES));

		actor.attemptsTo(Click.on(DLPage.PUBLISH_BTN));
		
		actor.attemptsTo(WaitUntil.the(DLPage.CONFIRM_BTN, isClickable()).then(Click.on(DLPage.CONFIRM_BTN)));
		waitABit(999);

	}

}
