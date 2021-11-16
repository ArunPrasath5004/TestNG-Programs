package org.hotel;

import java.util.Date;
import java.util.List;

import org.add.BaseClass;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Main extends BaseClass{
	
	@BeforeClass
	private void beforeClass() {
		browserLaunch("chrome");
		driver.manage().window().maximize();
		getUrl("http://adactinhotelapp.com/");
		timeWait(10);
	}
	
	@BeforeMethod
	private void before() {
		System.out.println("test start time === "+new Date());
		
	}
	@AfterMethod
	private void after() {
		System.out.println("test ends time === "+new Date());
	}
	
	@Test
	private void test() throws InterruptedException {
		Login l=new Login();
		
		sendValues(l.getUserName(), "ArunPrasath5005");
		sendValues(l.getPassword(), "Adactin@123");
		clickBtn(l.getLoginBtn());
		timeWait(5);
		
		RoomType r=new RoomType();
		
		dropElements(r.getLocation(), "New York");
		dropElements(r.getHotels(), "Hotel Sunshine");
		dropElements(r.getRoomTypes(), "Standard");
		dropElements(r.getNoOfRooms(), "1");
		clearValues(r.getCheckInDate());
		sendValues(r.getCheckInDate(), "30/09/2021");
		clearValues(r.getChechOutDate());
		sendValues(r.getChechOutDate(), "01/10/2021");
		dropElements(r.getNoOfAdults(), "1");
		dropElements(r.getNoOfChild(), "1");
		clickBtn(r.getSubmit());
		timeWait(5);
		
		SelectHotel s=new SelectHotel();
		
		clickBtn(s.getCheckbox());
		clickBtn(s.getContin());
		timeWait(5);
		
		HotelBooking h=new HotelBooking();
		
		sendValues(h.getFirstName(), "Arun");
		sendValues(h.getLastName(), "Prasath");
		sendValues(h.getAddress(), "david street,Boston, New York ");
		sendValues(h.getCreditCard(), "4001 5900 0000 0001");
		dropElements(h.getCardType(), "MAST");
		dropElements(h.getExpiryMonth(), "5");
		dropElements(h.getExpiryyear(), "2022");
		sendValues(h.getCvv(), "737");
		clickBtn(h.getBookNow());
		Thread.sleep(5000);
		
		BookConfrim cn=new BookConfrim();
		String orderID = getTheAttribute(cn.getMyBooking());
		System.out.println("Order ID == "+orderID);
	
		
		MyBookings bk=new MyBookings();
		clickBtn(bk.getMyBookings());
		timeWait(5);
		
		CancelOrderText tx=new CancelOrderText();
		
		
		for (int i = 0; i < tx.getPageText().size(); i++) {
			String allText = getTheAttribute(tx.getPageText().get(i));
			
			if (allText.equals(orderID)) {
				clickBtn(tx.getCheckBox());
				clickBtn(tx.getCancelSelected());
				System.out.println("Canceled = "+allText);
				Thread.sleep(2000);
				popup("accept");
				
			}
		}
		
		
		
		
		
		
		
//		CancelOrder cl=new CancelOrder();
//		
//		sendValues(cl.getSearchBox(), orderID);
//		clickBtn(cl.getSearch());
//		Thread.sleep(2000);
//		clickBtn(cl.getOrderAllId());
//		clickBtn(cl.getCancelSelected());
//		popup("accept");
		
	}
	
//	@AfterClass
//	private void afterClass() {
//		browserClose();
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
