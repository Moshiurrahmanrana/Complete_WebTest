package TestRunner;

import Pages.Login;
import Pages.PurchaseItem;
import Setup.Setup;
import Utils.Utils;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class DashboardTestRunner extends Setup {
    PurchaseItem objPurchase;
    Login objLogin;
    Utils utils;
    @BeforeTest
    public void doLogin() throws IOException, ParseException, InterruptedException {
        driver.get("http://automationpractice.com");
        utils=new Utils(driver);
        utils.readJSONFile();
        String email=utils.getEmail();
        String password=utils.getPassword();

        objLogin=new Login(driver);
        objLogin.doLogin(email,password);

    }
    @Test(enabled = true, description = "Check cart")
    public void checkHasCart() throws Exception {
        objPurchase = new PurchaseItem(driver);
        boolean status= objPurchase.checkHasCart();
        Assert.assertEquals(status,true);
        utils.addDescription("User can view cart");

    }
    @Test(enabled = true, description = "Check order history")
    public void checkOrderHistory() throws Exception {
        objPurchase = new PurchaseItem(driver);
        String headerText= objPurchase.orderHistory();
        Assert.assertEquals(headerText,"ORDER HISTORY");
        utils.addDescription("User can view his/her order history");
    }
}