package amazonPackage;

import base.CommonAPI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Homepage2 extends CommonAPI {

    @FindBy(id = "nav-orders")
    WebElement orderTab;

    @FindBy(xpath = "//a[@id='nav-hamburger-menu']")
    WebElement hamburger;

    @FindBy(id = "twotabsearchtextbox")
    WebElement inputSearch;



    public void setOrderTab(){
        System.out.println(driver.getCurrentUrl());
       // orderTab.click();
    }

//    public void setHamburger(){
//        if (hamburger.isDisplayed()){
//            Assert.assertTrue(true);
//            hamburger.click();
//        }
//    }

    public void setInputSearch(String name) throws InterruptedException{
        if(inputSearch.isEnabled()){

            inputSearch.sendKeys(name, Keys.ENTER);
        }
        Thread.sleep(5000);
    }
}
