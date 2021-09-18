package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "//span[contains(text(),'Order history and details')]")
    WebElement btnOrderHistory;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[2]/a/span")
    WebElement btnCreditSlips;
    @FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/ul[1]/li[1]/a[1]/span[1]")
    WebElement ReturnBtn;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a/span")
    WebElement btnMyAddress;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div[1]/div/div/ul/li[9]/a[1]/span")
    WebElement updateBtn;
    @FindBy(id = "firstname")
    WebElement FirstName;
    @FindBy(xpath = "//*[@id=\"submitAddress\"]/span")
    WebElement saveAddress;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/a/span")
    WebElement ReturnBtnAddress;
    @FindBy(className = "page-heading")
    WebElement textAddress;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span")
    WebElement btnPersonalInfo;
    @FindBy(id = "lastname")
    WebElement LastName;
    @FindBy(xpath = "//*[@id=\"center_column\"]/div/form/fieldset/div[11]/button/span")
    WebElement SaveInfo;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/a/span")
    WebElement ReturnPersonalInfo;
    @FindBy(className = "page-subheading")
    WebElement TextInformation;
    @FindBy(id = "old_passwd")
    WebElement OldPassword;
    @FindBy(id = "passwd")
    WebElement newPassword;
    @FindBy(id = "confirmation")
    WebElement confirmPass;





    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean checkHasCart(){
        wait=new WebDriverWait(driver,30);
        boolean status=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#header > div:nth-child(3) > div > div > div:nth-child(3) > div"))).isDisplayed();
        return status;
    }
    public String orderHistory(){
        btnOrderHistory.click();
        wait=new WebDriverWait(driver,30);
        String headerText=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h1[contains(text(),'Order history')]"))).getText();
        ReturnBtn.click();
        return headerText;
    }
    public String MyCredit(){
        btnCreditSlips.click();
        wait=new WebDriverWait(driver,30);
        String CreditText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"center_column\"]/h1"))).getText();
        return CreditText;
    }
    public String MyAddress(){
        btnMyAddress.click();
        wait=new WebDriverWait(driver,30);
        updateBtn.click();
        FirstName.sendKeys("moshiur");
        saveAddress.click();
        String GetText=textAddress.getText();
        ReturnBtnAddress.click();
        return GetText;
    }
    public String MyPersonalInfo(){
        btnPersonalInfo.click();
        LastName.sendKeys("Rahman");
        OldPassword.sendKeys("easy1234");
        newPassword.sendKeys("hard1234");
        confirmPass.sendKeys("hard1234");
        SaveInfo.click();
        String textPersonal =TextInformation.getText();
        ReturnPersonalInfo.click();
        return  textPersonal;
    }

}