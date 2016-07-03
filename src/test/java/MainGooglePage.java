import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class MainGooglePage {

    private final WebDriver driver;
    public static final String startGoogleLink = "https://www.google.com.ua/";

    public static final By searchLocator = By.id("lst-ib");
    public static final By locatorStartSearch = By.name("btnG");
    public static final By locatorAllLink2 = By.xpath(".//*[@id='rso']/div[2]/li/div/h3/a");
    public static final By locatorAllLink = By.xpath(".//*[@id='rso']//h3/a");

    public MainGooglePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchDataInGoogle(String data) {
        driver.findElement(searchLocator).sendKeys(data);
        driver.findElement(locatorStartSearch).click();
    }

    public void checkStartGoogle() {
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    public String getTitlePage() {
        return driver.getTitle();
    }

    public List<WebElement> getListWebElement(){
        return  driver.findElements(locatorAllLink);
    }

    public List<String> getListLink(){
        ArrayList<String> linkList = new ArrayList<String>();
        for (int i = 0; i < getListWebElement().size(); i++) {
            linkList.add(getListWebElement().get(i).getText().toString());
        }
        return linkList;
    }

    public void openMewLink() throws InterruptedException {
        System.out.println(getListLink().size());
        if (getListLink().size()!=0){
            for (int i = 0; i < getListLink().size(); i++) {
                System.out.println(getListLink().get(i));
                driver.findElement(By.linkText(getListLink().get(i))).click();
                driver.getTitle();
                Thread.sleep(1000);
                driver.navigate().back();
                Thread.sleep(300);
            }
        }
    }
}
