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

public class PurchaseTestRunner extends Setup {
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
    @Test(enabled = true, description = "Search products" )
    public void checkSearchTextBox() throws Exception {
        objPurchase = new PurchaseItem(driver);
        String result= objPurchase.checkSearch();
        Assert.assertTrue(result.contains("results have been found"));
        utils.addDescription("User can search by product in search box");

    }
    @Test(enabled = true, description = "Purchase product")
    public void doPurchase() throws Exception {

        objPurchase = new PurchaseItem(driver);
        String successMessage= objPurchase.purchaseItem();
        Assert.assertEquals(successMessage,"Your order on My Store is complete.");
        utils.addDescription("User can purchase a product successfully");

    }
}


