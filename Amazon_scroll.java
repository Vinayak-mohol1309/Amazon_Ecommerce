package java_selenium_project_pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Amazon_scroll {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\VINAYAK\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.in/?&ext_vrnc=hi&tag=googhydrabk1-21&ref=pd_sl_g50zekzm1_e&adgrpid=74238127911&hvpone=&hvptwo=&hvadid=610644609009&hvpos=&hvnetw=g&hvrand=1313545957245504467&hvqmt=e&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9062096&hvtargid=kwd-29089120&hydadcr=5496_2359482&gclid=CjwKCAiA2rOeBhAsEiwA2Pl7Q3__5I1FW8S0p3qzaaHxbwpoBRIbZAn7Kqe58MedazrQ47s2uq2uNRoCSD0QAvD_BwE");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		//down cast the upcasted object
		RemoteWebDriver d1 = (RemoteWebDriver) driver;
		Thread.sleep(5000);
		int y = d1.findElement(By.xpath("//h2[text()='Birthday store']")).getLocation().getY();

		d1.executeScript("window.scrollTo(0," + y + ")");
		Thread.sleep(5000);
		d1.close();

	}

}
