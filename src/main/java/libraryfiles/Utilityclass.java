package libraryfiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.print.attribute.standard.PrinterMessageFromOperator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilityclass {
	
	public static String getTDfmpc(String key) throws EncryptedDocumentException, IOException
	{
		//FileInputStream file=new FileInputStream("C:\\Users\\Prasad\\sayalieclipse-workspace\\Selenium\\propertyfile.properties");
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\propertyfile.properties");
Properties p=new Properties();
p.load(file);
   String value = p.getProperty(key);
	return  value;	
	}
	public static String getTD(int rowIndex,int colIndex) throws EncryptedDocumentException, IOException
	{
		//FileInputStream file=new FileInputStream("C:\\Users\\Prasad\\Desktop\\abc\\fetchdata.xlsx");
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\abc\\fetchdata.xlsx");
        Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
           String result = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
           return result;
	}
	public static void captureSS(WebDriver driver,int TCID) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File dest=new File("C:\\Users\\Prasad\\sayalieclipse-workspace\\Selenium\\failedscreenshots\\TC"+TCID+".jpg");
		File dest=new File(System.getProperty("user.dir")+"\\failedscreenshots\\TC\\" +TCID+ ".jpg");
		FileHandler.copy(src, dest);
	}

}
