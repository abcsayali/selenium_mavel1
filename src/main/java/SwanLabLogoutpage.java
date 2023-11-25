

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwanLabLogoutpage {
	@FindBy(xpath="//a[@id='logout_sidebar_link']")private WebElement Logout;
	
	public  SwanLabLogoutpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		}
	
	
	public void clickLogout()
	{
		Logout.click();
	}
}
