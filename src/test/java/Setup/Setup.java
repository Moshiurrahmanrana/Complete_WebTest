package Setup;


import Utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Setup {
    public WebDriver driver;
    @BeforeTest(groups = {"login","purchase_product"})
    public void setUp() throws IOException {
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headed");
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod  //AfterMethod annotation - This method executes after every test execution
    public void screenShot(ITestResult result)  {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                Utils util = new Utils(driver);
                util.takeScreenShot();
            } catch (Exception exception) {
                System.out.println(exception.toString());
            }

        }

    }

    @AfterTest(groups = {"login","purchase_product"})
    public void Logout() {
        driver.close();

    }
}