package tests;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.ProxySettings;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.StitchMode;

public class Relistor_Tests_Chrome {
	static URI serverURL = null;

	public static void main(String[] args) throws URISyntaxException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Winium\\ChromeDriver_Latest\\chromedriver.exe");
		// Open a Chrome browser.
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Initialize the eyes SDK and set your private API key.
		serverURL = new URI("https://eyesapi.applitools.com");
		Eyes eyes = new Eyes(serverURL);
		//String APIKEY = "ut2T71rUCYPEawNe3V3BDJI4aWQUs2PrXjNLP104uQjh4110";
		String APIKEY = "2nNTedspJlewIZPPsFN1012g104IYpOz27U9899eLy82AJY108Q110";
		eyes.setApiKey(APIKEY);
		eyes.setProxy(new ProxySettings("http://10.1.125.155:3128"));
		eyes.setForceFullPageScreenshot(true);
		eyes.setHideScrollbars(true);
		eyes.setStitchMode(StitchMode.CSS);
		
		// obtain the batch name and ID from the environment variables
		String batchName = System.getenv("APPLITOOLS_BATCH_NAME");
		String batchId   = System.getenv("APPLITOOLS_BATCH_ID");

		// set the batch
		BatchInfo batchInfo = new BatchInfo(batchName); 
		batchInfo.setId(batchId);
		eyes.setBatch(batchInfo);
		
		try {

			eyes.open(driver, "Home", "Relistor_Chrome1170*650", new RectangleSize(1170, 650));
			// Navigate the browser to the "hello world!" web-site.
			// driver.get("http://relistorqa.evoq-stg-i.com/");
			driver.get("http://relistor.evoq-dev.com");
			Thread.sleep(3000);
			driver.findElement(By.xpath(".//*[@id='dnn_ctr_Login_Login_DNN_txtUsername']")).sendKeys("Uatuser");
			driver.findElement(By.xpath(".//*[@id='dnn_ctr_Login_Login_DNN_txtPassword']")).sendKeys("Valeant$1");
			//eyes.checkWindow("Login Page");
			driver.findElement(By.id("dnn_ctr_Login_Login_DNN_cmdLogin")).click();
			Thread.sleep(2000);
			eyes.checkWindow("Home Page");
			// Saving Card Page
			WebElement SavingCard = driver
					.findElement(By.xpath("//*[@id='dnn_ctr48038_HtmlModule_lblContent']/div/a/div/div[1]/img"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", SavingCard);
			eyes.checkWindow("Saving Card Page");
			Thread.sleep(2000);
			driver.findElement(By.id("mobile-menu-button")).click();
			driver.findElement(By.xpath("//*[@id='#wrapper logged-out']/header/nav[2]/div[1]/ul/li[4]/div")).click();
			eyes.checkWindow("SavingCard Menu Check");
			Thread.sleep(1000);
			// About Panisipation Page
			driver.findElement(By.xpath(".//*[@id='#wrapper logged-out']/header/nav[2]/div[1]/ul/li[1]/a")).click();
			eyes.checkWindow("About Panisipation Page");
			Thread.sleep(1000);
			driver.findElement(By.id("mobile-menu-button")).click();
			eyes.checkWindow("About Panisipation menu check");
			Thread.sleep(1000);			
			
			// Talk To Your Doctor page
			WebElement TalkToDoctor = driver
					.findElement(By.xpath("//*[@id='dnn_ctr48059_HtmlModule_lblContent']/div/a/img"));
			executor.executeScript("arguments[0].click();", TalkToDoctor);
			eyes.checkWindow("Talk To Your Doctor page");
			Thread.sleep(2000);
			driver.findElement(By.id("mobile-menu-button")).click();
			driver.findElement(By.xpath("//*[@id='#wrapper logged-out']/header/nav[2]/div[1]/ul/li[1]/div")).click();
			eyes.checkWindow("Talk To Your Doctor menu check");
			Thread.sleep(2000);
			
			// About Relistor Page
			driver.findElement(By.xpath(".//*[@id='#wrapper logged-out']/header/nav[2]/div[1]/ul/li[2]/a")).click();
			eyes.checkWindow("About Relistor Page");
			Thread.sleep(1000);
			driver.findElement(By.id("mobile-menu-button")).click();
			eyes.checkWindow("About Relistor menu check");
			Thread.sleep(1000);

			// Possible Side Effects of RELISTOR Page
			WebElement PossibleEffects = driver
					.findElement(By.xpath("//*[@id='dnn_ctr48061_HtmlModule_lblContent']/div[2]/div[4]/p[3]/a"));
			executor.executeScript("arguments[0].click();", PossibleEffects);
			eyes.checkWindow("Possible Side Effects of RELISTOR Page");
			driver.findElement(By.id("mobile-menu-button")).click();
			driver.findElement(By.xpath("//*[@id='#wrapper logged-out']/header/nav[2]/div[1]/ul/li[2]/div")).click();
			eyes.checkWindow("Side Effects Menu Check");
			Thread.sleep(2000);
			
			// Taking Relistor page
			WebElement TakingRelistor = driver
					.findElement(By.xpath(".//*[@id='#wrapper logged-out']/header/nav[2]/div[1]/ul/li[3]/a"));
			executor.executeScript("arguments[0].click();", TakingRelistor);
			eyes.checkWindow("Taking Relistor page");
			Thread.sleep(1000);
			driver.findElement(By.id("mobile-menu-button")).click();
			eyes.checkWindow("About Panisipation menu check");
			Thread.sleep(1000);

			// Taking RELISTOR Tablets Page
			WebElement Tablets = driver.findElement(By.xpath("//*[@id='dnn_ctr48066_HtmlModule_lblContent']/p[1]/a"));
			executor.executeScript("arguments[0].click();", Tablets);
			eyes.checkWindow("Taking RELISTOR Tablets Page");

			driver.findElement(By.id("mobile-menu-button")).click();
			driver.findElement(By.xpath("//*[@id='#wrapper logged-out']/header/nav[2]/div[1]/ul/li[3]/div")).click();
			eyes.checkWindow("RELISTOR Tablets Menu Check");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='mobile-menu-button']")).click();
			
			// Taking RELISTOR Injection page
			driver.navigate().back();
			WebElement Injection = driver.findElement(By.xpath("//*[@id='dnn_ctr48066_HtmlModule_lblContent']/p[2]/a"));
			executor.executeScript("arguments[0].click();", Injection);
			eyes.checkWindow("Taking RELISTOR Injection page");
			driver.findElement(By.id("mobile-menu-button")).click();
			driver.findElement(By.xpath("//*[@id='#wrapper logged-out']/header/nav[2]/div[1]/ul/li[3]/div")).click();
			eyes.checkWindow("RELISTOR Injection Menu Check");
			Thread.sleep(2000);
			
			// Patient Resources Page
			WebElement PatientResources = driver
					.findElement(By.xpath(".//*[@id='#wrapper logged-out']/header/nav[2]/div[1]/ul/li[4]/a"));
			executor.executeScript("arguments[0].click();", PatientResources);
			eyes.checkWindow("Patient Resources Page");
			Thread.sleep(2000);
			driver.findElement(By.id("mobile-menu-button")).click();
			eyes.checkWindow("Patient Resources menu check");
			Thread.sleep(1000);

			// Helpful Websites Page
			WebElement HelpfulWebSite = driver
					.findElement(By.xpath("//*[@id='dnn_ctr48071_HtmlModule_lblContent']/div[3]/div/a"));
			executor.executeScript("arguments[0].click();", HelpfulWebSite);
			eyes.checkWindow("Helpful Websites Page");
			Thread.sleep(2000);
			driver.findElement(By.id("mobile-menu-button")).click();
			WebElement submenu = driver.findElement(By.xpath("//*[@id='#wrapper logged-out']/header/nav[2]/div[1]/ul/li[4]/div"));
			executor.executeScript("arguments[0].click();", submenu);
			eyes.checkWindow("Helpful Websites menu check");
			Thread.sleep(2000);
			
			// Contact Us Page
			WebElement ContactUs = driver
					.findElement(By.xpath("//*[@id='dnn_ctr48035_HtmlModule_lblContent']/ul/li[6]/a"));
			executor.executeScript("arguments[0].click();", ContactUs);
			eyes.checkWindow("Contact Us Page");

			// Site Map Page
			WebElement sitemap = driver
					.findElement(By.xpath("//*[@id='dnn_ctr48035_HtmlModule_lblContent']/ul/li[9]/a"));
			executor.executeScript("arguments[0].click();", sitemap);
			eyes.checkWindow("Site Map Page");
			Thread.sleep(1000);
			driver.findElement(By.id("mobile-menu-button")).click();
			eyes.checkWindow("Sitemap menu check");
			Thread.sleep(1000);

			driver.findElement(By.id("mobile-menu-button")).click();
			Thread.sleep(2000);
			
			// For Healthcare Professionals Page
			WebElement HealthCare = driver
					.findElement(By.xpath("//*[@id='#wrapper logged-out']/header/nav[2]/div[2]/ul/li[5]/a/strong"));
			executor.executeScript("arguments[0].click();", HealthCare);
			eyes.checkWindow("For Healthcare Professionals Page");

			// I conform Button click
			driver.findElement(By.xpath(".//*[@id='processhcp']")).click();
			Thread.sleep(2000);
			// Switch to new Tab
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			Thread.sleep(3000);
			eyes.checkWindow("Healthcare Professionals");
			driver.close();
			driver.switchTo().window(tabs.get(0));
			Thread.sleep(3000);

			// Legal Notice Page
			WebElement legalNotice = driver
					.findElement(By.xpath("//*[@id='dnn_ctr48035_HtmlModule_lblContent']/ul/li[7]/a"));
			executor.executeScript("arguments[0].click();", legalNotice);
			Thread.sleep(3000);
			ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs1.get(1));
			Thread.sleep(3000);
			eyes.checkWindow("Legal Notice Page");
			driver.close();
			driver.switchTo().window(tabs1.get(0));
			Thread.sleep(3000);

			// Privacy Policy Page
			WebElement PrivacyPolicy = driver
					.findElement(By.xpath("//*[@id='dnn_ctr48035_HtmlModule_lblContent']/ul/li[8]/a"));
			executor.executeScript("arguments[0].click();", PrivacyPolicy);
			Thread.sleep(3000);
			ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
			Thread.sleep(3000);
			eyes.checkWindow("Privacy Policy Page");
			driver.close();
			driver.switchTo().window(tabs2.get(0));

			// End the test.
			eyes.close();

		} finally {

			// Close the browser.
			driver.quit();

			// If the test was aborted before eyes.close was called, ends the
			// test as aborted.
			eyes.abortIfNotClosed();
		}

	}

}
