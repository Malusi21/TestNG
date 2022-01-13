package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestNGUI {
    WebDriver driver = null;
    JavascriptExecutor js = null;
    Variables var = new Variables();


    private static class Variables {
        String MyStor_Home = "https://www.gumtree.co.za";
        String chrome_path = "C:\\Users\\malusi.msomi\\Documents\\GitHub\\TestNG-attempt\\src\\main\\resources\\drivers\\chromedriver.exe";
        String gumtree_label = "/html/body/div[1]/div[3]/header/div[3]/nav/div[2]/span/span[contains(@class,\"label\")]";
        String cache_proceed_btn = "/html/body//div[2]/button[contains(.,\"Proceed\")]";

    }

    @BeforeClass
    public void SetChromeBrowserDriver(){
        System.setProperty("webdriver.chrome.driver",var.chrome_path);
        driver = new ChromeDriver();

    }
    @BeforeMethod
    public void Load_Browser_and_navigate_to_registration(){
        SetChromeBrowserDriver();
        js = (JavascriptExecutor) driver;
        driver.get(var.MyStor_Home);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath(var.gumtree_label)).isDisplayed();
        verifyHomePageLoad();
    }

    public void verifyHomePageLoad(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = driver.getCurrentUrl();
        UserCurrentPage(url);
    }
    public void UserCurrentPage(String url){
        if(url.equals("https://www.gumtree.co.za")){
            System.out.println("Correct page is being presented to the user");
        } else {
            System.out.println("User is presented with another page");
        }
    }

    @Test
    public void ClickProceed(){
        driver.findElement(By.xpath(var.cache_proceed_btn)).isDisplayed();
        driver.findElement(By.xpath(var.cache_proceed_btn)).click();
        driver.findElement(By.xpath(var.gumtree_label)).isDisplayed();
        driver.findElement(By.xpath(var.gumtree_label)).click();
    }

    @AfterMethod
    public void close_the_browser(){
        driver.close();
        driver.quit();
    }
}
