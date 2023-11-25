

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwanLabHomePage {
	
	@FindBy(xpath="//button[text()='Open Menu']")  private WebElement menu;
	WebDriver driver;
public SwanLabHomePage(WebDriver driver)
{    this.driver=driver;
	PageFactory.initElements(driver,this);
}

public String verifyResult()
{
	String actres = driver.getTitle();
	return actres;
	
}
public void clickMenuBtn()
{
	menu.click();
}
}
