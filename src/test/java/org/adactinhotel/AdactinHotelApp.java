package org.adactinhotel;

import java.io.IOException;

import org.base.BaseClass;
import org.locators.BookHotel;
import org.locators.BookingConfirmation;
import org.locators.Login;
import org.locators.Search;
import org.locators.SelectHotel;

public class AdactinHotelApp extends BaseClass{
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		launchBrowser();
		launchUrl();
		String path="C:\\Users\\jacky\\Desktop\\Vino\\Workspace\\AdactinHotelApp\\Excel\\adactinhotel.xlsx";
		
		Login login = new Login();
		sendKeys(login.getTxtUserName(),readExcel(path,"Sheet1", 1, 0));
		sendKeys(login.getTxtPassword(),readExcel(path,"Sheet1", 1, 1));
		login.getBtnLogin().click();
		
		Search search=new Search();
		sendKeys(search.getLocation(), readExcel(path,"Sheet1", 1, 2));
		sendKeys(search.getNoOfRooms(), readExcel(path,"Sheet1", 1, 3));
		sendKeys(search.getCheckInDate(), readExcel(path,"Sheet1", 1,4));
		sendKeys(search.getCheckOutDate(), readExcel(path,"Sheet1", 1,5));
		search.getSubmit().click();
		
		SelectHotel hotel=new SelectHotel();
		hotel.getRadio().click();
		hotel.getBtnContinue().click();
		
		BookHotel	bookHotel=new BookHotel();
		sendKeys(bookHotel.getFirstName(), readExcel(path,"Sheet1", 1, 7));
		sendKeys(bookHotel.getLastName(), readExcel(path,"Sheet1", 1, 8));
		sendKeys(bookHotel.getAddress(), readExcel(path,"Sheet1", 1, 9));
		sendKeys(bookHotel.getCardNo(), readExcel(path,"Sheet1", 1, 10));
		selectByVisibleText(bookHotel.getCardType(), readExcel(path,"Sheet1", 1, 11));
		selectByVisibleText(bookHotel.getExpMonth(), readExcel(path,"Sheet1", 1, 12));
		selectByVisibleText(bookHotel.getExpyear(), readExcel(path,"Sheet1", 1, 13));
		sendKeys(bookHotel.getCvvNumber(), readExcel(path,"Sheet1", 1, 14));
		bookHotel.getBookNow().click();
		
		Thread.sleep(5000);
		BookingConfirmation ConfrimBooking=new BookingConfirmation();
		writeExcel(path,"Sheet1", 1, 15, getAttribute(ConfrimBooking.getOrderNo(), "Value"));
		
		driver.quit();
		
	}
	

}
