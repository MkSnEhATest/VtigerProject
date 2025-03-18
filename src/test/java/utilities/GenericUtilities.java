package utilities;

import java.awt.Robot;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class GenericUtilities {
	public void selectOptionsByindex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	public void selectOptionsByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	public void selectOptionsByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public void deselectOptionsByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.deselectByIndex(index);
	}

	public void deselectOptionsByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.deselectByValue(value);
	}

	public void deselectOptionsByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.deselectByVisibleText(text);
	}

	public void deselectAllOptions(WebElement element) {
		Select s = new Select(element);
		s.deselectAll();
	}

	public void getAllOptions(WebElement element) {
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
	}

	public void getAllSelectedOptions(WebElement element) {

		Select s = new Select(element);
		List<WebElement> alloptions = s.getAllSelectedOptions();

		for (WebElement option : alloptions) {
			System.out.println(option.getText());
		}
	}

	public void getFirstOption(WebElement element) {
		Select s = new Select(element);
		System.out.println(s.getFirstSelectedOption().getText());
	}
	
	public void verifyDropdownIsMultiple(WebElement element) {
		Select s = new Select(element);
		System.out.println(s.isMultiple()?"Dropdown is multi select":"Dropdown is single select");
	}
	 
	public void MouseHoverOn(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	
	public void MouseHoverTo(WebDriver driver,WebElement element,int x,int y) {
		Actions act = new Actions(driver);
		act.moveToElement(element,x,y).perform();
		
	}
	public void ClickAndHoldElement(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}
	public void release(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.release(element).perform();
	}
	public void DragAndDropElement(WebDriver driver,WebElement element,WebElement src,WebElement dst) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}
	
	public void DragAndDropElementBy(WebDriver driver,WebElement element,WebElement src,int x,int y) {
		Actions act = new Actions(driver);
		act.dragAndDropBy(src, x,y).perform();
	}
	
	public void doubleClickButton(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	public void rightClickButton(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	public void pressKey(int keycode) {
		try {
			Robot robo = new Robot();
			robo.keyPress(keycode);
			
		} catch (Exception e) {
			System.out.println("unable to press the key");
		}
	}
	public void keyrelease(int keycode) {
		try {
			Robot robo = new Robot();
			robo.keyPress(keycode);
			
		} catch (Exception e) {
			System.out.println("unable to release the key");
		}
	}
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void DismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void PassDataToAlert(WebDriver driver,String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	public void GetAlertMessage(WebDriver driver,String text) {
		driver.switchTo().alert().getText();
	}
	public void SwitchControlToNewTab(WebDriver driver) {
		String pid = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		
		for (String id : allId) {
			if(!id.equals(allId)) {
				driver.switchTo().window(id);
			}
		}
	}
	public void SwitchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	public void SwitchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	public void SwitchToWebPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	public void PassDataToTextFieldUsingJSE(WebDriver driver,String id,String value) {
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("document.getElementBId(' "+ id + " ').value="+value);
	}
	public void ClickRadioButtonUsingJSE(WebDriver driver,String id) {
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("document.getElementBId(' "+ id + " ').checked=true");
		}
	public void CheckTheCheckBoxUsingJSE(WebDriver driver,String id,String value) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("document.getElementBId(' "+ id + " ').checked=true");
	}
	public void ScrolltoElement(WebDriver driver,WebElement element) {
		int x = element.getLocation().getX();
		int y= element.getLocation().getY();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(" +x+"," +y +")");
	}
	public void Scroll(WebDriver driver,int x,int y) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(" +x+"," +y +")");
	}
	public String currentDate() {
		return new Date().toString().replaceAll(":","_").replaceAll("","_");
	}
	public String CaptureScreenshot(WebDriver driver,String path) {
		
		File dst;
		
		try {
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			 dst = new File(path);
			Files.copy(src, dst);
			System.out.println("Screenshot captured successfully");
		} catch (Exception e) {
			System.out.println("Screenshot captured unsuccessfully");
		}
		
		return path;
	}
	}


