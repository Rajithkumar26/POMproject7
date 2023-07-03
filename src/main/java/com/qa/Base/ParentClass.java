package com.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.qa.Excel.ExcelReader;
import com.qa.UtilitiesPackage.ExtentManagerClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ParentClass {

//	public Properties OR = new Properties();
	public static Properties config;
	public FileInputStream fis;
public static WebDriver driver;
public static ExtentReports extentreport= ExtentManagerClass.getInstance();
public static ExtentTest test;
public static ExcelReader Excelfile=new ExcelReader("C:\\Users\\Vaibhav\\eclipse-workspace\\POMproject7\\src\\test\\Excel\\testdata_POMproject7.xlsx");

	public ParentClass() throws IOException {
		config = new Properties();
		fis = new FileInputStream(
				"C:\\Users\\Vaibhav\\eclipse-workspace\\POMproject7\\src\\test\\properties\\Config.properties");
		config.load(fis);

		
	}

	public static void initiaizationMethod() {
		String browserName= config.getProperty("browser");
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions op = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			prefs.put("profile.default_content_setting_values.notifications", 2);

			op.setExperimentalOption("prefs", prefs);
			op.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
			op.addArguments("--remote-allow-origins=*");

		driver= new ChromeDriver(op);
		}
		driver.get(config.getProperty("testsiteurl"));
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	public  void  CloseBrowser() {
		driver.quit();
	}
}
