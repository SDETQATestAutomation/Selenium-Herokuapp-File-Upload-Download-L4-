package com.iiht.evaluation.automation;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.*;

public class App{
    public static WebDriver driver = null;
    static String downloadPath = "./downloads";

    @BeforeClass
    public static void setup() {
        System.out.println("\nBefore method setup");
        String req_chrome_driver_path = System.getProperty("user.dir") + "/binaries/chromedriver.exe";
        System.out.println(req_chrome_driver_path);
        String base_url = "https://the-internet.herokuapp.com/";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-cross-origin-auth-prompt");
        options.addArguments("--allow-control-allow-origin");
        options.addArguments("-–allow-file-access-from-files");
        options.addArguments("--test-type");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");
        options.addArguments("--lang=en");
        options.addArguments("--no-sandbox");
        options.addArguments("disable-popup-blocking");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        options.addArguments("download.default_directory=" + downloadPath);
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9223");

        Map<String, Object> loggingPrefs = new HashMap<>();
        loggingPrefs.put("driver", "INFO");
        loggingPrefs.put("server", "OFF");
        loggingPrefs.put("browser", "INFO");
        options.setCapability("goog:loggingPrefs", loggingPrefs);
        options.setCapability("acceptInsecureCerts", true);

        ChromeDriverService service = new ChromeDriverService.Builder().usingDriverExecutable(new File(req_chrome_driver_path)).build();
        driver = new ChromeDriver(service, options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //driver.get(base_url);
        SubActivities.check_page_load_complete(driver);
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

}
