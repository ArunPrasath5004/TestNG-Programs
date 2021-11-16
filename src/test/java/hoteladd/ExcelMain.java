package hoteladd;


import org.add.BaseClass;
import org.hotel.BookConfrim;
import org.hotel.HotelBooking;
import org.hotel.Login;
import org.hotel.MyBookings;
import org.hotel.RoomType;
import org.hotel.SelectHotel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExcelMain extends BaseClass {
	
	@BeforeClass
	private void beforeClass() {
		browserLaunch("chrome");
		driver.manage().window().maximize();
		getUrl("http://adactinhotelapp.com/");
		
	}
	
	@Test
	private void test() throws Exception {
		Login l=new Login();
		
		sendValues(l.getUserName(),driven("Book1", "Hotel", 0, 0));
		sendValues(l.getPassword(), driven("Book1", "Hotel", 0, 1));
		clickBtn(l.getLoginBtn());
		timeWait(5);
		
		RoomType r=new RoomType();
		
		dropElements(r.getLocation(), "New York");
		dropElements(r.getHotels(), "Hotel Sunshine");
		dropElements(r.getRoomTypes(), "Standard");
		dropElements(r.getNoOfRooms(), "1");
//		clearValues(r.getCheckInDate());
//		sendValues(r.getCheckInDate(), Driven("Book1", "Hotel", 2, 0));
//		clearValues(r.getChechOutDate());
//		sendValues(r.getChechOutDate(), Driven("Book1", "Hotel", 2, 1));
		dropElements(r.getNoOfAdults(), "1");
		dropElements(r.getNoOfChild(), "1");
		clickBtn(r.getSubmit());
		timeWait(5);
		
		SelectHotel s=new SelectHotel();
		
		clickBtn(s.getCheckbox());
		clickBtn(s.getContin());
		timeWait(5);
		
		HotelBooking h=new HotelBooking();
		
		sendValues(h.getFirstName(),driven("Book1", "Hotel", 4, 0));
		sendValues(h.getLastName(),driven("Book1", "Hotel", 4, 1));
		sendValues(h.getAddress(), driven("Book1", "Hotel", 5, 0));
		sendValues(h.getCreditCard(), driven("Book1", "Hotel", 5, 1));
		dropElements(h.getCardType(), "MAST");
		dropElements(h.getExpiryMonth(), "5");
		dropElements(h.getExpiryyear(), "2022");
		sendValues(h.getCvv(), driven("Book1", "Hotel", 5, 2));
		clickBtn(h.getBookNow());
		Thread.sleep(5000);
		
		BookConfrim cn=new BookConfrim();
		String orderID = getTheAttribute(cn.getMyBooking());
		System.out.println("Order ID == "+orderID);
	
		dataWrite("Book1", "Hotel", 10, 1, orderID);
		
		
		
		MyBookings bk=new MyBookings();
		clickBtn(bk.getMyBookings());
		timeWait(5);
		
		
		
	}
	
	@AfterClass
	private void afterClass() {
		browserClose();
	}

}
