package com.ults.selenium.configurationfiles;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.ults.selenium.commonfunctions.CommonFunctions;
import com.ults.selenium.util.CacheManager;
import com.ults.selenium.util.ConfigConstant;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseConfiguration extends CommonFunctions implements ConfigConstant {

    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {
        String browserName = CacheManager.getString(selenium_browser_name);
        if (browserName == null || browserName.isEmpty()) {
            browserName = "chrome"; // Default to chrome if not set
        }
        System.out.println("Browser name: " + browserName);

        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                // Add IE driver setup here if needed
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;
    }

    public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }
}