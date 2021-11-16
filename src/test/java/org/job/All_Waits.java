package org.job;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.add.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class All_Waits extends BaseClass{


	@Test
	private void test() {
		
//		1. implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		2. Explict wait
		
//		2(a). webdriver wait
		WebDriverWait w=new WebDriverWait(driver, 50);
		
//		Alert
		Alert as = w.until(ExpectedConditions.alertIsPresent());
		as.accept();
		
//		frames
		WebDriver d = w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("email"));
	
//		textbox
		WebElement wb = w.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
		wb.sendKeys("456778");
		
//		window change and URL verify
		w.until(ExpectedConditions.urlContains("privacy"));
		String url = getUrl();
		System.out.println(url);
		
//		In Actions element is clickable 
		WebElement clk = w.until(ExpectedConditions.elementToBeClickable(By.id("login")));
		clk.click();
		
		
//		2(b). Fluent wait
		FluentWait<WebDriver> fl=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(Throwable.class);	
		
		
		
		
		
		
		
		
		
	}
	




}
