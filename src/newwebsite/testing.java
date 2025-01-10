package newwebsite;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testing {
	WebDriver driver = new ChromeDriver();
	String MyWebsite = "https://codenboxautomationlab.com/practice/";
	Random rand = new Random();
	
	@BeforeTest 
	public void MySetup() {
		
		driver.get(MyWebsite);
		driver.manage().window().maximize();
		
		
		
	}
	
	@Test(priority=1, description="Radio butten", enabled = false)
	public void RadioButten() {
		
		List<WebElement> allradiobutton = driver.findElements(By.className("radioButton"));
		int randomindex = rand.nextInt(allradiobutton.size());
		allradiobutton.get(randomindex).click();

		
	}

	@Test(priority=2, description= "dinamic dropdown", enabled= false)
	public void dinamicdropdown() throws InterruptedException {
		String[] contrycode = {"jo", "om","eg","am","fr","kw","ua"};
		int randomindex = rand.nextInt(contrycode.length);
		
		WebElement contryinput= driver.findElement(By.id("autocomplete"));
		contryinput.sendKeys(contrycode[randomindex]);
		Thread.sleep(1000);
		contryinput.sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ENTER));
		
		
	}
	
	@Test(priority=3, description = "static dropdown", enabled = false)	
	public void staticdropdown() {
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select sel = new Select(dropdown);
		//sel.selectByIndex(2);
		//sel.selectByValue("option1");
		sel.selectByVisibleText("API");
		
	}
	
	@Test(priority=4, description= "check box", enabled = false)
	public void checkbox() throws InterruptedException {
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int randomindex = rand.nextInt(checkboxes.size());
		Thread.sleep(2000);
	    checkboxes.get(randomindex).click();
		//checkboxes.getFirst().click();
	//	checkboxes.getLast().click();
		
	}
	
	@Test(priority=5, description = "jumping to another window", enabled = false)
	public void newwindow() throws InterruptedException {
		
		WebElement newwindow = driver.findElement(By.id("openwindow"));
		newwindow.click();
		Thread.sleep(2000);
		List<String> widoweshandeles = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(widoweshandeles.get(1));
		WebElement contactbutton = driver.findElement(By.id("menu-item-9680"));
		contactbutton.click();
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(widoweshandeles.get(0));
		
	}
	
	@Test(priority=6, description= "jumping to other tab")
	public void newtap() throws InterruptedException {
		WebElement newtap = driver.findElement(By.id("opentab"));
		newtap.click();
		List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(2000);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	@Test(priority = 7, description = "switch to alert", enabled= false)
	public void alertandconfirm() throws InterruptedException {
		WebElement input = driver.findElement(By.id("name"));
		input.sendKeys("Banan");
		Thread.sleep(1000);

		//WebElement alertbutton = driver.findElement(By.id("alertbtn"));
		//alertbutton.click();
		//Thread.sleep(1000);
		//driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();
		
		WebElement confirmbutton = driver.findElement(By.id("confirmbtn"));
		confirmbutton.click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();
		
		
	}
	
	
	
	
	
	
	
}
