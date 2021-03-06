package test.java.PO;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopLogoPanel extends BasePage {

    By btnCallback = By.xpath("//a[@class='callback-btn']");
    By inputName = By.xpath("//input[@id='b-contacte__full-name']");
    By inputTel = By.xpath("//input[@id='b-contacte-phone-tel']");
    By btnSubmit = By.xpath("//input[@value='Отправить']");
    By callbackMessage = By.xpath("//div[@class='b-header-contacte-phone-thank']");

    public TopLogoPanel(WebDriver driver) {
        super(driver);
    }

    @Step("Open Callback Form")
    public TopLogoPanel openCallbackForm() {
        logger.info("Open Callback Form");
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnCallback));
        actions.moveToElement(driver.findElement(btnCallback)).click().build().perform();
        return this;
    }

    @Step("Fill Callback Form")
    public TopLogoPanel fillCallbackForm() {
        logger.info("Fill Callback Form");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnSubmit));
        driver.findElement(inputName).sendKeys("Test Antony");
        driver.findElement(inputTel).sendKeys("0123456789");
        return this;
    }

    @Step("Fill Empty Callback Form")
    public TopLogoPanel fillEmptyCallbackForm() {
        logger.info("Fill Empty Callback Form");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnSubmit));
        return this;
    }

    @Step("Send Callback Form")
    public TopLogoPanel sendCallbackForm() {
        logger.info("Send Callback Form");
        driver.findElement(btnSubmit).click();
        return this;
    }

    @Step("Get Message From Form")
    public String getMessageFromForm() {
        logger.info("Get Message From Form");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(callbackMessage));
        String msg = driver.findElement(callbackMessage).getText();
        return msg;
    }

    @Step("Get Border Red From Form")
    public String getBorderRedFromForm() {
        logger.info("Get Border Red From Form");
        String borderRed = driver.findElement(inputName).getAttribute("style");
        return borderRed;
    }

}
