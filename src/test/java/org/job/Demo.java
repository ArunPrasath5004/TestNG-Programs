package org.job;

import org.add.BaseClass;
import org.demo.LoginPom;
import org.hotel.BookConfrim;
import org.hotel.HotelBooking;
import org.hotel.Login;
import org.hotel.RoomType;
import org.hotel.SelectHotel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Demo extends BaseClass{

	

//	@Test(dataProvider="login",dataProviderClass=Datas.class)
//	private void test1(String user,String pass) throws InterruptedException {
//		getUrl("http://adactinhotelapp.com/");
//		Login l=new Login();
//
//		sendValues(l.getUserName(), user);
//		sendValues(l.getPassword(), pass);
//		clickBtn(l.getLoginBtn());
//		timeWait(5);
//	}	
//
//	@Test(dataProvider="Date",dataProviderClass=Datas.class)
//	private void test2(String chekIn,String checkOut) {
//		RoomType r=new RoomType();
//
//		dropElements(r.getLocation(), "New York");
//		dropElements(r.getHotels(), "Hotel Sunshine");
//		dropElements(r.getRoomTypes(), "Standard");
//		dropElements(r.getNoOfRooms(), "1");
//		clearValues(r.getCheckInDate());
//		sendValues(r.getCheckInDate(), chekIn);
//		clearValues(r.getChechOutDate());
//		sendValues(r.getChechOutDate(), checkOut);
//		dropElements(r.getNoOfAdults(), "1");
//		dropElements(r.getNoOfChild(), "1");
//		clickBtn(r.getSubmit());
//		timeWait(5);
//	}
//
//	@Test
//	private void test3() {
//		SelectHotel s=new SelectHotel();
//
//		clickBtn(s.getCheckbox());
//		clickBtn(s.getContin());
//		timeWait(5);			
//	}
//
//
//	@Test(dataProvider="Bio",dataProviderClass=Datas.class)
//	private void test4(String first,String last,String address,String card,String cvv) throws InterruptedException {
//		HotelBooking h=new HotelBooking();
//
//		sendValues(h.getFirstName(), first);
//		sendValues(h.getLastName(), last);
//		sendValues(h.getAddress(), address);
//		sendValues(h.getCreditCard(), card);
//		dropElements(h.getCardType(), "MAST");
//		dropElements(h.getExpiryMonth(), "5");
//		dropElements(h.getExpiryyear(), "2022");
//		sendValues(h.getCvv(), cvv);
//		clickBtn(h.getBookNow());
//		Thread.sleep(5000);			
//	}
//	
//	@Test
//	private void test5() {
//		BookConfrim cn=new BookConfrim();
//		String orderID = getTheAttribute(cn.getMyBooking());
//		System.out.println("Order ID == "+orderID);
//
//	}









		@Test(dataProvider="login",dataProviderClass=C.class)
		private void test(String user,String pass) {
			
			browserLaunch("chrome");
			getUrl("https://en-gb.facebook.com/");
			
			LoginPom l=new LoginPom();
			sendValues(l.getUserName(), user);
			
			sendValues(l.getPassword(), pass);
			
			clickBtn(l.getLoginBtn());
			
			System.out.println(Thread.currentThread().getId());
			
		}
		
		

}
