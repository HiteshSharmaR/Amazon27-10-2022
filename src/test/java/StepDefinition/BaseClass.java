package StepDefinition;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    WebDriver driver;
    WebDriverWait wait;

    public void Setup() throws IOException {
        FileReader reader = new FileReader("src/test/java/PropertyFile/Config.properties");
        Properties data = new Properties();
        data.load(reader);
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.get(data.getProperty("url"));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,Duration.ofSeconds(15));
    }

    public void close() {
        driver.quit();
    }
}
