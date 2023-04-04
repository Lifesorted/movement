package com.movement.app.page_objects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class DLPage extends PageObject {

	public static Target ADD_DL = Target.the("add dl").locatedBy("//div[@class='bg-primary-2 position-fixed border-radius-16 add-timeline']");
	public static Target MEETING_NOTES = Target.the("meeting notes").locatedBy("//textarea[@id='Topic']");
	public static Target SELECT_PRESENCE0 = Target.the("select").locatedBy("//select[@Id='chg_0']");
	public static Target SELECT_PRESENCE1 = Target.the("select").locatedBy("//select[@Id='chg_1']");
	public static Target SELECT_PRESENCE2 = Target.the("select").locatedBy("//select[@Id='chg_2']");
	public static Target SELECT_PRESENCE3 = Target.the("select").locatedBy("//select[@Id='chg_3']");
	public static Target SELECT_PRESENCE4 = Target.the("select").locatedBy("//select[@Id='chg_4']");
	public static Target SELECT_PRESENCE5 = Target.the("select").locatedBy("//select[@Id='chg_5']");
	public static Target SELECT_PRESENCE6 = Target.the("select").locatedBy("//select[@Id='chg_6']");
	public static Target PUBLISH_BTN = Target.the("publish").locatedBy("//input[@value='Publish']");
	public static Target SAVE_AS_DRAFT_BTN = Target.the("draft").locatedBy("//input[@value='Save as draft']");
	public static Target CONFIRM_BTN = Target.the("confirm").locatedBy("//button[contains(text(),'Ok')]");
	public static Target ADDED_TIME = Target.the("confirm").locatedBy("(//p[@class='timeline-item-date float-right text-right mb-0'])[1]/span");

}