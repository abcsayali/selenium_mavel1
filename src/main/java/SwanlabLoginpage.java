

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwanlabLoginpage {
	
  @FindBy(xpath="(//input[@class='input_error form_input'])[1]")  private WebElement UN;
   @FindBy(xpath="(//input[@class='input_error form_input'])[2]")private WebElement PWD;
  @FindBy(xpath="//input[@id='login-button']")private WebElement LoginBtn;
  
  public SwanlabLoginpage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
  public void InputEnterUN(String username) throws InterruptedException 
  {   UN.clear();
  //Thread.sleep(1000);
	  UN.sendKeys(username);
  }
  public void InputEnterPWD(String password) throws InterruptedException
  {  PWD.clear();
  //Thread.sleep(1000);
	  PWD.sendKeys(password);
  }
  public void ClickLOginbutton()
  {
	  LoginBtn.click();
  }
}
