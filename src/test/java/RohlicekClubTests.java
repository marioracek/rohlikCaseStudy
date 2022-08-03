import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import pages.RohlicekClubPO;

import java.time.Duration;

public class RohlicekClubTests {

    WebDriver driver;
    RohlicekClubPO rohlicekPO;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://www.rohlik.cz/rohlicek");
    }

    @Test
    public void login() {
        rohlicekPO = new RohlicekClubPO(driver);
        rohlicekPO.clickOnAllowCookiesButton();
        waitForPresenceOfElement(30, "xpath", "//*[contains(@data-test, 'IconChat')]");
        rohlicekPO.clickOnLoginButton();
        waitForPresenceOfElement(30, "id", "email");
        rohlicekPO.enterEmail("mario.racek@gmail.com");
        //production password should not be visible in code
        rohlicekPO.enterPassword("");
        rohlicekPO.clickOnSubmitLoginButton();
        waitForPresenceOfElement(30, "id", "headerUserImage");
    }

    @Test(priority = 1)
    public void testAddingChild() {
        rohlicekPO = new RohlicekClubPO(driver);

        assertTrue(rohlicekPO.becomeMemberButtonIsDisplayed());

        rohlicekPO.clickOnBecomeMemberButton();
        waitForPresenceOfElement(30, "xpath", "//p[contains(@data-test, 'babyClub-registration-conditions')]");

        assertEquals(rohlicekPO.getNumberOfChildOptions(), 2, "There are 2 child options to pick");

        rohlicekPO.clickOnChildUntilTwelveInput();

        assertTrue(rohlicekPO.boyOptionIsDisplayed());
        assertTrue(rohlicekPO.girlOptionIsDisplayed());

        rohlicekPO.clickIconBabyGirlInput();
        waitForPresenceOfElement(30, "id", "name");

        assertTrue(rohlicekPO.childDateOfBirthInputIsDisplayed());
        assertTrue(rohlicekPO.childNameInputIsDisplayed());

        rohlicekPO.enterName("Tereza");
        rohlicekPO.enterDateOfBirth("01/29/2021");
        waitForElementToBeClickable(30, "xpath", "//button[contains(@data-test, 'babyClub-registration-button')]");
        rohlicekPO.clickRegisterButton();
        waitForPresenceOfElement(30, "xpath", "//div[contains(@data-test, 'modal-body')]//div[contains(@class, 'sc-1geegzo-0 jrbqPx u-typographyCenter')]");

        assertEquals(rohlicekPO.getWelcomeMessage(), "Vítejte v Rohlíčku");
        assertTrue(rohlicekPO.goShoppingButtonElementIsDisplayed());
        assertTrue(rohlicekPO.showClubDiscountsButtonElementIsDisplayed());
    }

    public void waitForPresenceOfElement(long time, String selector, String elementName) {
        switch (selector) {
            case "xpath":
                new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementName)));
                break;
            case "id":
                new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.presenceOfElementLocated(By.id(elementName)));
                break;
            default:
                break;
        }
    }

    public void waitForElementToBeClickable(long time, String selector, String elementName) {
        switch (selector) {
            case "xpath":
                new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.elementToBeClickable(By.xpath(elementName)));
                break;
            case "id":
                new WebDriverWait(driver, Duration.ofSeconds(time)).until(ExpectedConditions.elementToBeClickable(By.id(elementName)));
                break;
            default:
                break;
        }
    }

    @AfterTest
    public void close() {
        driver.close();
    }
}
