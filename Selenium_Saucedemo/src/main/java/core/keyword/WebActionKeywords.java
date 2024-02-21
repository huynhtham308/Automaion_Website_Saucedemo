package core.keyword;

import io.cucumber.java.bs.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebActionKeywords {
    WebDriver _driver;
    WebDriverWait _wait;

    public WebActionKeywords(WebDriver driver) {
        this._driver = driver;
        this._wait = new WebDriverWait(this._driver, Duration.ofSeconds(30));
    }

    public void openUrl(String url) throws Exception {
        if (url.startsWith("http:") || (url.startsWith("https:"))) {
            this._driver.get(url);
        }
        throw new Exception("url invalid");
    }

    public WebElement findElement(By locator) throws Exception {
        try{
            return (WebElement) this._wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        }catch (Exception e){
            throw new Exception("no find webelement by"+locator);
        }
    }

    // sendkeys, click, select, openUrl
    public void sendKey(By locator, String key) {
        try {
            WebElement element = this._driver.findElement(locator);

            element.clear();
            element.sendKeys(key);
        } catch (WebDriverException e) {
            throw new WebDriverException("Element is not enable to set text");
        }
    }

    public void click(By locator) throws Exception {
        try {
            WebElement element = findElement(locator);

            if (element.isDisplayed() && element.isEnabled()) {
//                ((JavascriptExecutor) _driver).executeScript("arguments[0].scrollIntoView(true);", element);
                Actions action = new Actions(this._driver);
                action.moveToElement(element).build().perform();
                element.click();
            }
            else {
                throw new Exception("no found element");
            }
        } catch (Exception e) {
            e.getMessage();
        }


    }

    public void select(By locator, SelectType type, String options) throws Exception {
        Select select = new Select(this._driver.findElement(locator));
        switch (type) {
            case SELECT_BY_INDEX:
                try {
                    select.selectByIndex(Integer.parseInt(options));
                } catch (Exception e) {
                    throw new Exception("Please input numberic on selectOption for SelectType.SelectByIndex");
                }
                break;
            case SELECT_BY_TEXT:
                select.selectByVisibleText(options);
                break;
            case SELECT_BY_VALUE:
                select.selectByValue(options);
                break;
            default:
                throw new Exception("Get error in using Selected");
        }
    }

    public enum SelectType {
        SELECT_BY_INDEX,
        SELECT_BY_TEXT,
        SELECT_BY_VALUE,
        SELECT_B,
    }
}
