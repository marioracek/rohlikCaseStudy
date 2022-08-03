package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RohlicekClubPO {

    WebDriver driver;

    By becomeMemberElement = By.cssSelector(".sc-1232tqx-0.bfKMFa.u-mt--40");
    By loginElement = By.id("headerLogin");
    By emailElement = By.id("email");
    By passwordElement = By.id("password");
    By submitElement = By.xpath("//form[contains(@data-test, 'user-login-form')]//button[contains(@data-test, 'btnSignIn')]");
    By cookiesElement = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    By childUntilTwelveElement = By.xpath("//label[contains(@class, 'sc-1t131uy-0 jjCoai RadioBtn sc-spy7ew-5 klUArY')]//span[contains(@class, 'inputPH')]");
    By babyGirlElement = By.xpath("//*[contains(@data-test, 'IconBabyGirl')]");
    By babyGirlButtonElement = By.xpath("//div[contains(@data-test, 'babyClub-genderForm-wrapper')]//*[contains(@data-test, 'IconBabyGirl')]");
    By babyBoyButtonElement = By.xpath("//div[contains(@data-test, 'babyClub-genderForm-wrapper')]//*[contains(@data-test, 'IconBabyBoy')]");
    By registerButtonElement = By.xpath("//*[contains(@data-test, 'babyClub-registration-button')]");
    By inputNameElement = By.id("name");
    By inputDateOfBirthElement = By.name("birthday");
    By childOptionsInputs = By.xpath("//div[contains(@class, 'sc-spy7ew-1 bkopEn')]//div");
    By welcomeToRohlicekElement = By.xpath("//div[contains(@data-test, 'modal-body')]//div[contains(@class, 'sc-1geegzo-0 jrbqPx u-typographyCenter')]");
    By goShoppingButtonElement = By.xpath("//*[@id=\"modalOverlay\"]/div/div/div[1]/div[5]/button[1]");
    By showClubDiscountsButtonElement = By.xpath("//*[@id=\"modalOverlay\"]/div/div/div[1]/div[5]/button[2]");

    public RohlicekClubPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLoginButton() {
        driver.findElement(loginElement).click();
    }

    public void clickOnBecomeMemberButton() {
        driver.findElement(becomeMemberElement).click();
    }

    public void clickOnAllowCookiesButton() {
        driver.findElement(cookiesElement).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailElement).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordElement).sendKeys(password);
    }

    public void clickOnSubmitLoginButton() {
        driver.findElement(submitElement).click();
    }

    public void clickOnChildUntilTwelveInput() {
        driver.findElement(childUntilTwelveElement).click();
    }

    public void clickIconBabyGirlInput() {
        driver.findElement(babyGirlElement).click();
    }

    public void enterName(String name) {
        driver.findElement(inputNameElement).sendKeys(name);
    }

    public void enterDateOfBirth(String dateOfBirth) {
        driver.findElement(inputDateOfBirthElement).sendKeys(dateOfBirth);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButtonElement).click();
    }

    public boolean becomeMemberButtonIsDisplayed() {
        return driver.findElement(becomeMemberElement).isDisplayed();
    }

    public int getNumberOfChildOptions() {
        return driver.findElements(childOptionsInputs).size();
    }

    public boolean girlOptionIsDisplayed() {
        return driver.findElement(babyGirlButtonElement).isDisplayed();
    }

    public boolean boyOptionIsDisplayed() {
        return driver.findElement(babyBoyButtonElement).isDisplayed();
    }

    public boolean childNameInputIsDisplayed() {
        return driver.findElement(inputNameElement).isDisplayed();
    }

    public boolean childDateOfBirthInputIsDisplayed() {
        return driver.findElement(inputDateOfBirthElement).isDisplayed();
    }

    public String getWelcomeMessage() {
        return driver.findElement(welcomeToRohlicekElement).getText();
    }

    public boolean goShoppingButtonElementIsDisplayed() {
        return driver.findElement(goShoppingButtonElement).isDisplayed();
    }

    public boolean showClubDiscountsButtonElementIsDisplayed() {
        return driver.findElement(showClubDiscountsButtonElement).isDisplayed();
    }

}
