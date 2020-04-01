package testpackage;

import amazonPackage.Homepage2;
import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestHomePage extends CommonAPI {
    Homepage2 homapage2;

    @BeforeClass
    public void init() {
        homapage2 = PageFactory.initElements(driver, Homepage2.class);
    }


    @Test
    public void clickOnOder() {
        homapage2.setOrderTab();
    }

//    @Test
//    public void clickOnHamBurger() {
//        homapage2.setHamburger();
//    }

//    @Test
//    public void searchItems() throws InterruptedException {
//        homapage2.setInputSearch("Mobile");
//    }

}
