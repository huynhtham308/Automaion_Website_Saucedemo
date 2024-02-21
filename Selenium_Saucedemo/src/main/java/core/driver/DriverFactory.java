package core.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
//    public WebDriver getDriver(String browser){
//        switch (browser){
//            case "firefox":
//               WebDriverManager.firefoxdriver().setup();
//                FirefoxOptions options=new FirefoxOptions();
//                options.addArguments("--incognito");
////                options.addArguments("--window-size=1600,700");
////                options.addArguments("--start-fullscreen");
//                return new FirefoxDriver();
//
//            case "edge":
//                WebDriverManager.edgedriver().setup();
//                EdgeOptions option=new EdgeOptions();
//                option.addArguments("--incognito");
////                option.addArguments("--window-size=1600,700");
////                option.addArguments("--start-fullscreen");
//
//                return  new EdgeDriver();
////            case "chrome":
////                WebDriverManager.chromedriver().setup();
////                return new ChromeDriver();
//            default:
//                WebDriverManager.chromedriver().setup();
//                ChromeOptions ops = new ChromeOptions();
//                ops.addArguments("--incognito");
//
//                return new ChromeDriver(ops);
//        }
//    }
public WebDriver getDriver(String browser){
    switch (browser){
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        case "edge":
            WebDriverManager.edgedriver().setup();
            return new InternetExplorerDriver();
        default:
            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--incognito");
            return new ChromeDriver(ops);
    }

}

}
