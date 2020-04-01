package base;


import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonAPI {



    public static final String BROWSERSTACK_USERNAME = "aklidjebra1";
    public static final String BROWSERSTACK_AUTOMATE_KEY = "SEUZKCwBzDDgAkmqYKx5";
    public static final String SAUCE_USERNAME = "";
    public static final String SAUCE_AUTOMATE_KEY = "";
    public static final String BROWSERSTACK_URL = "https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public static final String SAUCE_URL = "https://" + SAUCE_USERNAME + ":" + SAUCE_AUTOMATE_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    public static WebDriver driver = null;

    @Parameters({"platform", "url", "browserName", "useCloudEnv", "browserVersion", "cloudEnvName"})
    @BeforeMethod
    public static WebDriver setupDriver(String platform, String url, @Optional("chrome") String browserName,  boolean useCloudEnv, String browserVersion, String cloudEnvName) throws MalformedURLException {
        if (useCloudEnv) {
            driver = getCloudDriver(browserName, browserVersion, platform, cloudEnvName);
        } else {
            driver = getLocalDriver(browserName, platform);
        }
        driver.get(url);
        return driver;
    }


    public static  WebDriver getCloudDriver(String browserName, String browserVersion,  String platform, String cloudEnvName) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("name","Cloud Execution");
        capabilities.setCapability("browser","chrome");
        capabilities.setCapability("browser_version","74.0");
        capabilities.setCapability("os", "OS X");
        capabilities.setCapability("os_version", "Mojave");
        capabilities.setCapability("resolution", "1024x768");


      if(cloudEnvName.equalsIgnoreCase("Saucelabs")){
    driver= new RemoteWebDriver(new URL(SAUCE_URL), capabilities);


      }else if (cloudEnvName.equalsIgnoreCase("Browserstack")){

          driver= new RemoteWebDriver(new URL(BROWSERSTACK_URL),capabilities);
      }




        return driver;
    }



    public static WebDriver getLocalDriver(String browserName, String platform){

        if(platform.equalsIgnoreCase("mac")&& browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "../Generic/src/main/resources/drivers/chromedriver");
        }else if (platform.equalsIgnoreCase("windows")&& browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "../Generic/src/main/resources/drivers/chromedriver.exe");

        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


        return driver;
    }

    @AfterClass
    public void cleanUp(){
        driver.quit();
    }

}
