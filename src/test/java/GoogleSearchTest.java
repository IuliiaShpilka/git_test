
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class GoogleSearchTest {

    private WebDriver browser;
    private MainGooglePage mainGooglePage;

    @BeforeClass
    public void setUp() {
        browser = new FirefoxDriver();
        browser.manage().window().maximize();
        browser.get(MainGooglePage.startGoogleLink);
        mainGooglePage = new MainGooglePage(browser);
        browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testing() throws InterruptedException {
        System.out.println(mainGooglePage.getTitlePage());
        mainGooglePage.checkStartGoogle();
        mainGooglePage.searchDataInGoogle("Den Simmons");

        mainGooglePage.openMewLink();
    }
}




