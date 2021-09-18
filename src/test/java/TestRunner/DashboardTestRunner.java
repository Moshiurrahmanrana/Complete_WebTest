package TestRunner;

import Pages.Dashboard;
import Pages.Login;
import Pages.PurchaseItem;
import Setup.Setup;
import Utils.Utils;
import okhttp3.internal.http2.Header;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class DashboardTestRunner extends Setup {
    Dashboard dashboard;
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
    @Test(enabled = true, description = "Check cart",priority = 1)
    public void checkHasCart() throws Exception {
        dashboard = new Dashboard(driver);
        boolean status= dashboard.checkHasCart();
        Assert.assertEquals(status,true);
        utils.addDescription("User can view cart");

    }
    @Test(enabled = true, description = "Check order history",priority = 2)
    public void checkOrderHistory() throws Exception {
        dashboard = new Dashboard(driver);
        String headerText= dashboard.orderHistory();
        Assert.assertEquals(headerText,"ORDER HISTORY");
        utils.addDescription("User can view his/her order history");
    }
    @Test(priority = 4)
    public void CheckCreditSlips(){
        dashboard = new Dashboard(driver);
        String CreditText = dashboard.MyCredit();
        Assert.assertEquals(CreditText,"CREDIT SLIPS");
        utils.addDescription("customer credit slips");
    }
    @Test(priority = 3)
    public void CheckMyAddress(){
        dashboard = new Dashboard(driver);
        String GetText = dashboard.MyAddress();
        Assert.assertEquals(GetText,"MY ADDRESSES");
        utils.addDescription("Customer address updated");
    }
    @Test
    public void checkPersonalInfo(){
        dashboard = new Dashboard(driver);
        String textPersonal = dashboard.MyPersonalInfo();
        Assert.assertEquals(textPersonal,"YOUR PERSONAL INFORMATION");
        utils.addDescription("customer personal information updated");
    }

}