package base;

import core.configuration.Configuration;
import core.keyword.WebActionKeywords;
import pages.components.Header;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver _driver;
    protected Header _header;
    WebActionKeywords _actionkeyword;
    public BasePage(WebDriver driver){
        this._driver = driver;
        this._header = new Header(this._driver);
        this._actionkeyword=new WebActionKeywords(this._driver);
    }

    public WebDriver get_driver() {
        return _driver;
    }

    public Header get_header() {
        return _header;
    }

    public WebActionKeywords get_actionkeyword() {
        return _actionkeyword;
    }
    public void navigate(String _url) throws Exception {
        this._actionkeyword.openUrl(_url);
    }

}
