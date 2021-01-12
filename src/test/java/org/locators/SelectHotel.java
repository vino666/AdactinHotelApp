package org.locators;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel extends BaseClass{
	
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="radiobutton_1")
	private WebElement radio;
	
	@FindBy(name="continue")
	private WebElement btnContinue;

	public WebElement getRadio() {
		return radio;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
	

}
